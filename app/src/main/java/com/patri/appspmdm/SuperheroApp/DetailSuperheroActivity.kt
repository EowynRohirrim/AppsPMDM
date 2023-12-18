package com.patri.appspmdm.SuperheroApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.patri.appspmdm.R
import com.patri.appspmdm.SuperheroApp.SuperheroListActivity.Companion.EXTRA_ID
import com.patri.appspmdm.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSuperheroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_detail_superhero)
        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()//Escoger la opcion de variable, la moradita al importar EXTRA_ID que es la de esta app //orEmpty() por la nulidad
        getSuperheroInformation(id)
    }


    private fun getSuperheroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail =
                getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)

            if(superheroDetail.body() != null){
                runOnUiThread { createUI(superheroDetail.body()!!) }//!! es para indicar que estoy seguro de que no es nulo
            }

        }

    }

    private fun createUI(superhero: SuperHeroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperhero)
        binding.tvSuperheroName.text = superhero.name //El atributo name del superhero
        binding.tvSuperheroRealName.text = superhero.biography.fullName
        binding.tvPublisher.text = superhero.biography.publisher
        prepareStats(superhero.powerstats)
    }

    /***/
    private fun prepareStats(powerstats: PowerStatsResponse) {
        updateHeight(binding.viewIntelligence, powerstats.intelligence) //La altura y le valor
        updateHeight(binding.viewStrength, powerstats.strength)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewPower, powerstats.power)
        updateHeight(binding.viewCombat, powerstats.combat)
    }

    /**Función para actualizar las alturas de los parámetros
     * Se le pasa un View o lo que estemos usando, podria ser un Textview o un CardView
     * y le pasamos el stats, el valor, en esta API vienen todos en forma de string, vienen entre comillas " "*/
    private fun updateHeight(view: View, stat:String){
        val params = view.layoutParams //Cogemos del view
        params.height = pxToDp(stat.toFloat()) //Le pasamos el float al params para darle la altura, los int quedan muy pequeños
        view.layoutParams = params
    }

    /**Para pasarle float porque en int se queda muy pequeño y no se ve bien
     * Convertir pixeles a DP*/
    private fun pxToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
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