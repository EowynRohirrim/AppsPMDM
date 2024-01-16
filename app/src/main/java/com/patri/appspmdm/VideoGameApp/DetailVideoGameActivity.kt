package com.patri.appspmdm.VideoGameApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.patri.appspmdm.R
import com.patri.appspmdm.SuperheroApp.ApiService
import com.patri.appspmdm.SuperheroApp.SuperHeroDetailResponse
import com.patri.appspmdm.SuperheroApp.SuperheroListActivity
import com.patri.appspmdm.databinding.ActivityDetailSuperheroBinding
import com.patri.appspmdm.databinding.ActivityDetailVideoGameBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailVideoGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailVideoGameBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVideoGameBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //setContentView(R.layout.activity_detail_superhero)
        val id: String = intent.getStringExtra(VideoGameListActivity.EXTRA_ID).orEmpty()//Escoger la opcion de variable, la moradita al importar EXTRA_ID que es la de esta app //orEmpty() por la nulidad
        getVideoGameInformation(id)

    }

    private fun getVideoGameInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val VideoGameDetail =
                getRetrofit().create(ApiService::class.java).getVideoGameDetail(id)

            if(VideoGameDetail.body() != null){
                runOnUiThread { createUI(VideoGameDetail.body()!!) }//!! es para indicar que estoy seguro de que no es nulo
            }
        }
    }

    private fun createUI(VideoGame: VideoGameDetailResponse) {
        Picasso.get().load(VideoGame.image.url).into(binding.ivVideoGame)
        binding.tvVideoGameName.text = VideoGame.name //El atributo name del superhero
        binding.tvVideoGameRealName.text = VideoGame.biography.fullName
        binding.tvPublisher.text = VideoGame.biography.publisher
        prepareStats(VideoGame.powerstats)
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