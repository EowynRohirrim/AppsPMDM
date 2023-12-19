package com.patri.appspmdm.IMCApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.slider.RangeSlider
import com.patri.appspmdm.R
import java.text.DecimalFormat
import java.lang.Math.pow


class IMCcalculator : AppCompatActivity() {

    //Para que por defecto este hombre seleccionado
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    //declaramos las variables arriba
    private var currentWeight: Int = 70
    private var currentAge: Int = 30
    private var currentHeight: Int = 120

    //Opcion de sexo
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    //El range slider
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider

    //El peso
    private lateinit var tvWeight: TextView
    private lateinit var btnSubstractWeight: CardView
    private lateinit var btnAddWeight: CardView

    //Edad
    private lateinit var tvAge: TextView
    private lateinit var btnSubstractAge: CardView
    private lateinit var btnAddAge: CardView


    private lateinit var btnCalculate: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imccalculator)

        initComponents()//Tiene que ir primero
        initListeners()
        setWeight()
        setAge()


    }

    private fun initComponents() {
        viewMale = findViewById<CardView>(R.id.viewMale)//CardView es redundante pero por si no funciona...
        viewFemale = findViewById<CardView>(R.id.viewFemale)

        //El range slider
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)

        //El peso
        tvWeight = findViewById(R.id.tvWeight)
        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)

        //La edad
        tvAge = findViewById(R.id.tvAge)
        btnSubstractAge = findViewById(R.id.btnSubstractAge)
        btnAddAge = findViewById(R.id.btnAddAge)

        //Boton Calcular
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener { setColorComponentMale() }
        viewFemale.setOnClickListener { setColorComponentFemale() }

        //El range slider
        //Crea tres atributos rangeslider, float y boolean
        //Si se le pone una _ barra baja no los usa
        rsHeight.addOnChangeListener { _, value, _ ->
            val df =DecimalFormat("#")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnSubstractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubstractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)//le pasamos un double

            //Para comprobar en la consola que el calculo lo hace bien, usamos:
            //Log.i("IMC", "El IMC es $result")
        }
    }

    private fun setColorComponentMale() {
        if(!isMaleSelected){//Si no está seleccionado hombre
            viewMale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component))
            isMaleSelected = true
            isFemaleSelected = false
        }
    }

    private fun setColorComponentFemale() {
        if(!isFemaleSelected){//Si no está seleccionado mujer
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewMale.setCardBackgroundColor(getColor(R.color.background_component))
            isFemaleSelected = true
            isMaleSelected = false
        }
    }

    private fun setWeight() { tvWeight.text = currentWeight.toString() }

    private fun setAge() { tvAge.text = currentAge.toString() }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / pow(currentHeight.toDouble() /100, 2.0)

        return df.format(imc).toDouble()
    }

    // Log.i("IMC", "El IMC es $result") en el método
    // setOnClickListener para mostrarlo por consola

    private fun navigateToResult(result: Double){
        val intent = Intent (this, ResultActivity::class.java)
        intent.putExtra("extra_IMC", result)
        startActivity(intent)
    }
}