package com.patri.appspmdm.SuperheroApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.patri.appspmdm.R
import com.patri.appspmdm.SuperheroApp.SuperheroListActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperheroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_superhero)
        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()//Escoger la opcion de variable, la moradita al importar EXTRA_ID que es la de esta app
        getSuperheroInformation(id)
    }

    private fun getSuperheroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail =
                getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)
        }

    }

    //Retrofit coge texto plano y lo convierte en clases en java
    //son dos librerias
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}