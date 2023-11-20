package com.patri.appspmdm.ColorsApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.patri.appspmdm.R

class ColorsActivity : AppCompatActivity() {


    private lateinit var rvColorsH : RecyclerView
    private lateinit var rvAdapter: Adapter



    /**override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)

        initcomponents()
        initUI()

        rvColorsH = findViewById(R.id.rvColorsH)
        rvAdapter = EjemploAdapter(listaEjemplo)

        rvEjemplo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvEjemplo.adapter = rvAdapter

    }

    private val verticalBars = mutableListOf(
        VerticalBar(871890688,"V1 (20%)"),
        VerticalBar(1509921024,"V2, (35%)"),
        VerticalBar(-2131230976,"V3, (50%)"),
        VerticalBar(-1509883935,"V4, ()"),
        VerticalBar(-85871793,"V5, ()"),


        )

    private lateinit var rvColorsH: RecyclerView

    private fun initcomponents() {
        rvColorsH = findViewById<RecyclerView>(R.id.rvColorsH)
    }

    private fun initUI(){
        horizontalAdapter = HorizontalAdapter(verticalBars)

    }
}