package com.patri.appspmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.patri.appspmdm.BoardGamesApp.BoardGameActivity
import com.patri.appspmdm.ColorsApp.ColorsActivity
import com.patri.appspmdm.HelloApp.MainActivity
import com.patri.appspmdm.IMCApp.IMCcalculator
import com.patri.appspmdm.MessageApp.MessageSending
import com.patri.appspmdm.Settings.SettingsActivity
import com.patri.appspmdm.SuperheroApp.SuperheroListActivity
import com.patri.appspmdm.VideoGameApp.VideoGameListActivity


class MenuActivity : AppCompatActivity() {

    //Aqui vamos a tener poco código Haremos todo funciones externas
    //para cuando haya errores todo se localice fácil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        //Creamos los botones y el ClickListener
        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        btnHelloApp.setOnClickListener{ navigateToHelloApp() }

        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        btnMessageApp.setOnClickListener{ navigateToMessageApp() }

        var btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        btnIMCApp.setOnClickListener{ navigateToIMCApp() }

        var btnBoardgameApp = findViewById<Button>(R.id.btnBoardGameApp)
        btnBoardgameApp.setOnClickListener{ navigateToBoardGameApp() }

        var btnColorsApp = findViewById<Button>(R.id.btnColorsApp)
        btnColorsApp.setOnClickListener{ navigateToColorsApp() }

        var btnSuperHeroApp = findViewById<Button>(R.id.btnSuperHeroApp)
        btnSuperHeroApp.setOnClickListener{ navigateToSuperHeroApp() }

        var btnVideoGameApp = findViewById<Button>(R.id.btnVideoGameApp)
        btnVideoGameApp.setOnClickListener{ navigateToVideoGameApp() }

        var btnSettingsApp = findViewById<Button>(R.id.btnSettingsApp)
        btnSettingsApp.setOnClickListener{ navigateToSettingsApp() }

    }


    /**
     * Fuera de la función onCreate()
     * funciones con los intent para lanzar las apps
     */
    private fun navigateToHelloApp(){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToMessageApp(){
        var intent = Intent(this, MessageSending::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp(){
        var intent = Intent(this, IMCcalculator::class.java)
        startActivity(intent)
    }

    private fun navigateToBoardGameApp(){
        var intent = Intent(this, BoardGameActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToColorsApp(){
        var intent = Intent(this, ColorsActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToSuperHeroApp(){
        var intent = Intent(this, SuperheroListActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToVideoGameApp() {
        var intent = Intent(this, VideoGameListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSettingsApp() {
        TODO("Not yet implemented")
        var intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

}