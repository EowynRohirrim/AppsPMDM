package com.patri.appspmdm.VideoGameApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.patri.appspmdm.R
import com.patri.appspmdm.databinding.ActivityVideoGameListBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VideoGameListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoGameListBinding //Para ahorrarnos pasos al declarar objetos
    private lateinit var retrofit: Retrofit

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
    }

    private fun searchByName(query: String?) {

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