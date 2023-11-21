package com.patri.appspmdm.SuperheroApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import com.patri.appspmdm.R
import com.patri.appspmdm.databinding.ActivitySuperheroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperheroListActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySuperheroListBinding
    private lateinit var retrofit: Retrofit

    /**Variable objeto retrofit*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySuperheroListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Con el biding podemos acceder a los mñetodos directamente ya no hace falta hacer un init

        retrofit = getRetrofit()

        initUI()
    }

    private fun initUI() {


        /**El objeto necesita dos métodos*/
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {


            /**Cuando se le envie el texto de la consulta
             * Cuando le de a la lupa
             */
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")

                /**Le pasamos el query, una cadena de texto
                 * con el orEmpty() para obligarle a que no sea nulo
                 * será algo o será vacío*/
                searchByName(query.orEmpty())

                /**Siempre se devuelve false*/
                return false
            }

            /**Que haga la búsqueda mediante se vaya escribiendo
             * Este no lo vamos a utilizar, solo vamos  usar el de la lupa
             */
            override fun onQueryTextChange(newText: String?) = false
        })
    }

    private fun searchByName(query: String) {

        /**Todo lo que escriba dentro de estas llaves ejecutalo de forma*/
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperHeroDataResponse> =
                retrofit.create(ApiService::class.java).getSuperheroes(query)

            if (myResponse.isSuccessful) {
                Log.i("Consulta", "Funciona :)")
            } else {
                Log.i("Consulta", "No funciona :(")
            }


        }
    }

    /**Devuelve un objeto retrofit*/
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}