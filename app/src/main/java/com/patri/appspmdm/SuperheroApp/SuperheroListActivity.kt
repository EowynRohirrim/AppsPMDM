package com.patri.appspmdm.SuperheroApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.patri.appspmdm.R
import com.patri.appspmdm.databinding.ActivitySuperheroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperheroListActivity : AppCompatActivity() {
    companion object { //declararlo como un objeto para todo el proyecto para enlazar actividades con el id
        const val EXTRA_ID = "extra_id" //como es una constante se pone mayuscula
    }


    private lateinit var binding: ActivitySuperheroListBinding //Estamos un objeto binding que es lo que vamos a usar para enlazar en vez del findByID
    private lateinit var retrofit: Retrofit
    /**Variable objeto retrofit*/

    //Adapter
    private lateinit var adapter: SuperheroAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySuperheroListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Con el biding podemos acceder a los mñetodos directamente ya no hace falta hacer un init

        retrofit = getRetrofit()

        initUI()
    }

    private fun initUI() {
        /**El objeto necesita dos métodos */
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            /**Cuando se le envie el texto de la consulta
             * Cuando le de a la lupa
             */
            override fun onQueryTextSubmit(query: String?): Boolean {

                /**Le pasamos el query, una cadena de texto
                 * con el orEmpty() para obligarle a que no sea nulo
                 * será algo o será vacío*/
                searchByName(query.orEmpty())

                return false /**Siempre se devuelve false*/
            }

            /**Que haga la búsqueda mediante se vaya escribiendo
             * Este no lo vamos a utilizar, solo vamos  usar el de la lupa*/
            override fun onQueryTextChange(newText: String?) = false
        })

        //Inicializamos el adapter
        adapter = SuperheroAdapter { superheroId ->  navigateToDetail(superheroId)} //la variable es un objeto SuperheroAdapter, como le hemos dado una lista vacía no hay que pasarle nada
        //adapter = SuperheroAdapter {avigateToDetail(it)} //it es de iteracion
        binding.rvSuperhero.setHasFixedSize(true)//setHasFixedSize es conveniente usarlo
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)//Definirle
        binding.rvSuperhero.adapter = adapter //con el método binding le asignamos el adapter
    }

    private fun searchByName(query: String) { //Recibe la consulta
        binding.progressBar.isVisible = true  //Que aparezca la progressBar TIENE que estar antes de la coroutuine
        /**Todo lo que escriba dentro de estas llaves ejecutalo de forma*/
        CoroutineScope(Dispatchers.IO).launch {//Para que no se quede colgada CORRUTINA

            val myResponse: Response<SuperHeroDataResponse> =
                retrofit.create(ApiService::class.java).getSuperheroes(query)
            /**Creo un objeto que recoge la respuesta
             * desntro de la aPI create(ApiService::class.java)
             * hemos cogido .getSuperheroes(query) que es la que devuelve al respuesta */

            if (myResponse.isSuccessful) { //isSuccessful si la repsuseta es exitosa sacamos por consola... el Log.i
                Log.i("Consulta", "Funciona :)")

                val response: SuperHeroDataResponse? =
                    myResponse.body()//Alamaceno el cuerpo de la respuesta
                if (response != null) {//Si no es nulo, es un poco redundante, PERO aunque haya una respuesta puede que no tenga cuerpo
                    Log.i("Cuerpo de la consulta", response.toString())//Imprime la respuesta
                    runOnUiThread {//Hilo principal, si lo hacemos desde la corrutina no las pinta
                        adapter.updateList(response.superheroes)//recibe la lista de los superheroes

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
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            /** URL base de la apì a la que vamos a acceder */
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailSuperheroActivity::class.java)//Declaramos intent en este contexto que va a lanzar la siguiente actividada Detail
        intent.putExtra(EXTRA_ID, id)//Le vamos a pasar el id, lo metemos en el extra y lo mandamos a la siguiente pantalla, es util cuando se tienen muchas pantallas
        startActivity(intent)
    }

}