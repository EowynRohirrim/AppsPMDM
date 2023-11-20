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


class MenuActivity : AppCompatActivity() {
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
}