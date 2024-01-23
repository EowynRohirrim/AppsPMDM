package com.patri.appspmdm.VideoGameApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.datastore.preferences.protobuf.Api
import androidx.recyclerview.widget.LinearLayoutManager
import com.patri.appspmdm.R
import com.patri.appspmdm.SuperheroApp.ApiService
import com.patri.appspmdm.SuperheroApp.SuperHeroDataResponse
import com.patri.appspmdm.databinding.ActivityVideoGameListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VideoGameListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoGameListBinding //Para ahorrarnos pasos al declarar objetos
    private lateinit var retrofit: Retrofit

    private lateinit var adapter : VideoGameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoGameListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = getRetrofit() //creamos el objeto cuando se crea la pantalla

        initUI()
    }

    private fun initUI() {

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            //Lo que se llama al pulsar el boton de buscar
            override fun onQueryTextSubmit(query: String?): Boolean {

                //Creo funcion buscar por nombre
                searchByName(query.orEmpty())//Si es vacio devuelve todo
                return false
            }

            //Cada vez que vayamos escribiendo, pero la dejamos en false, no interesa
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        adapter = VideoGameAdapter()
        binding.rvVideoGames.setHasFixedSize(true)
        binding.rvVideoGames.layoutManager = LinearLayoutManager(this)
        binding.rvVideoGames.adapter=adapter

    }

    private fun searchByName(query: String) { //Recibe la consulta
        binding.progressBar.isVisible = true  //Que aparezca la progressBar TIENE que estar antes de la coroutuine
        /**Todo lo que escriba dentro de estas llaves ejecutalo de forma*/
        CoroutineScope(Dispatchers.IO).launch {//Para que no se quede colgada CORRUTINA

            val myResponse: Response<VideoGameDataResponse> =
                retrofit.create(com.patri.appspmdm.VideoGameApp.ApiService::class.java).getVideoGames(query)
            /**Creo un objeto que recoge la respuesta
             * desntro de la aPI create(ApiService::class.java)
             * hemos cogido .getSuperheroes(query) que es la que devuelve al respuesta */

            if (myResponse.isSuccessful) { //isSuccessful si la repsuseta es exitosa sacamos por consola... el Log.i
                Log.i("Consulta", "Funciona :)")

                val response: VideoGameDataResponse? =
                    myResponse.body()//Alamaceno el cuerpo de la respuesta
                if (response != null) {//Si no es nulo, es un poco redundante, PERO aunque haya una respuesta puede que no tenga cuerpo
                    Log.i("Cuerpo de la consulta", response.toString())//Imprime la respuesta
                    runOnUiThread {//Hilo principal, si lo hacemos desde la corrutina no las pinta
                        adapter.updateList(response.VideoGames)//recibe la lista de los superheroes

                        binding.progressBar.isVisible = false //Cuando hayamos recibido los datos, la progressBar desaparezca
                    }
                }
            } else {
                Log.i("Consulta", "No funciona :(")
            }
        }
    }

    /** Devuelve un objeto retrofit */
    private fun getRetrofit(): Retrofit {
        //Se crea objeto y se devuelve
        return Retrofit
            .Builder()
            .baseUrl("https://api.rawg.io/api/")//No olvidar la barra final
            /** URL base de la apì a la que vamos a acceder */
            .addConverterFactory(GsonConverterFactory.create())//Tranforma a objeto
            .build()//construir el objeto
    }


}