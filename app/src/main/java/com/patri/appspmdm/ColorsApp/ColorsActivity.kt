package com.patri.appspmdm.ColorsApp




import android.app.Dialog
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.patri.appspmdm.R
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.patri.appspmdm.ColorsApp.*

class ColorsActivity : AppCompatActivity() {

    /**Variables para interactuar con el RecyclerView*/
    private lateinit var rvColorsH: RecyclerView //RecyclerView horizontal
    private lateinit var rvAdapter: HorizontalAdapter//Adapter
    //private lateinit var btnAddColor: Button //Mas abajo
    private lateinit var btnChangeColor: CardView

    /**Inicio la lista. FALLO. No la coge al arrancar la app. Preguntar*/
    private val verticalBars = mutableListOf(
        VerticalBar(Color.argb(20,20,20,20), "V1 (20%)"),
        VerticalBar(Color.argb(35,20,255,20), "V2 (35%)"),
        VerticalBar(Color.argb(50,80,20,20), "V3 (50%)"),
        VerticalBar(Color.argb(65,20,20,80), "V4 (65%)"),
        VerticalBar(Color.argb(80,200,20,20), "V5 (80%)"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)

        initcomponents()//Inicializa componentes
        initUI()//Inicializa la interfaz de usuario
        initListeners() //Inicio escuchadores
    }
    private fun initUI() {//inicio UI
        rvAdapter = HorizontalAdapter(verticalBars)//Al HorizontalAdapter le paso la lista
        //Definir orientación horizontal del ReyclerView
        rvColorsH.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //Y se le asigna el adapter con la lista asociada a él
        rvColorsH.adapter = rvAdapter
    }

    private fun initcomponents() {
        rvColorsH = findViewById<RecyclerView>(R.id.rvColorsH)//Inicio el RecyclerView
        btnChangeColor = findViewById(R.id.btnChangeColor)//Inicio el boton del layout principal
    }

    private fun initListeners() {
        btnChangeColor.setOnClickListener { showDialog() }//Lanza el diálogo
    }

    private fun showDialog() {
        /**Le pasamos la vista como diálogo*/
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_colors)

        /**Creamos la variables de las opciones con dialog. para indicar que está dentro del diálogo*/
        val btnAddColor: Button = dialog.findViewById(R.id.btnAddColor)//Botón añadir color
        val rgChooseBar: RadioGroup = dialog.findViewById(R.id.rgChooseBar)//Elige barrra
        val rgChooseColor: RadioGroup = dialog.findViewById(R.id.rgChooseColor)//Elige color

        /**Creamos las variables de las barras horizontales*/
        val cvH1: CardView = findViewById(R.id.cvH1)
        val cvH2: CardView = findViewById(R.id.cvH2)
        val cvH3: CardView = findViewById(R.id.cvH3)

        btnAddColor.setOnClickListener { /**Cuando se pulse añadir color*/

        val selectedBar = rgChooseBar.checkedRadioButtonId
            val selectedRadioButtonBar: RadioButton = rgChooseBar.findViewById(selectedBar)

            val selectedColor = rgChooseColor.checkedRadioButtonId
            val selectedRadioButtonColor: RadioButton = rgChooseColor.findViewById(selectedColor)

            /**Creo una array para gestionar el color y la opacidad*/
            var currentColor: Array<Int> = arrayOf(
                R.color.colorsapp_opacity_20,
                R.color.colorsapp_opacity_35,
                R.color.colorsapp_opacity_50,
                R.color.colorsapp_opacity_65,
                R.color.colorsapp_opacity_80
            )

            /**Si la elección de color no está vacía*/
            if (currentColor.isNotEmpty()) {

                /**Selección del color, guardo en arrays para poder asignarle el tono después*/
                when (selectedRadioButtonColor.text.toString()) {
                    getString(R.string.dialog_color_white) -> currentColor = arrayOf(
                        R.color.colorsapp_white_color20,
                        R.color.colorsapp_white_color35,
                        R.color.colorsapp_white_color50,
                        R.color.colorsapp_white_color65,
                        R.color.colorsapp_white_color80
                    )

                    getString(R.string.dialog_color_Red) -> currentColor = arrayOf(
                        R.color.colorsapp_red_color20,
                        R.color.colorsapp_red_color35,
                        R.color.colorsapp_red_color50,
                        R.color.colorsapp_red_color65,
                        R.color.colorsapp_red_color80
                    )

                    getString(R.string.dialog_color_orange) -> currentColor = arrayOf(
                        R.color.colorsapp_orange_color20,
                        R.color.colorsapp_orange_color35,
                        R.color.colorsapp_orange_color50,
                        R.color.colorsapp_orange_color65,
                        R.color.colorsapp_orange_color80
                    )

                    getString(R.string.dialog_color_yellow) -> currentColor = arrayOf(
                        R.color.colorsapp_yellow_color20,
                        R.color.colorsapp_yellow_color35,
                        R.color.colorsapp_yellow_color50,
                        R.color.colorsapp_yellow_color65,
                        R.color.colorsapp_yellow_color80
                    )

                    getString(R.string.dialog_color_green) -> currentColor = arrayOf(
                        R.color.colorsapp_green_color20,
                        R.color.colorsapp_green_color35,
                        R.color.colorsapp_green_color50,
                        R.color.colorsapp_green_color65,
                        R.color.colorsapp_green_color80
                    )

                    getString(R.string.dialog_color_cyan) -> currentColor = arrayOf(
                        R.color.colorsapp_cyan_color20,
                        R.color.colorsapp_cyan_color35,
                        R.color.colorsapp_cyan_color50,
                        R.color.colorsapp_cyan_color65,
                        R.color.colorsapp_cyan_color80
                    )

                    getString(R.string.dialog_color_blue) -> currentColor = arrayOf(
                        R.color.colorsapp_blue_color20,
                        R.color.colorsapp_blue_color35,
                        R.color.colorsapp_blue_color50,
                        R.color.colorsapp_blue_color65,
                        R.color.colorsapp_blue_color80
                    )

                    getString(R.string.dialog_color_violet) -> currentColor = arrayOf(
                        R.color.colorsapp_violet_color20,
                        R.color.colorsapp_violet_color35,
                        R.color.colorsapp_violet_color50,
                        R.color.colorsapp_violet_color65,
                        R.color.colorsapp_violet_color80
                    )

                    getString(R.string.dialog_color_black) -> currentColor = arrayOf(
                        R.color.colorsapp_opacity_20,
                        R.color.colorsapp_opacity_35,
                        R.color.colorsapp_opacity_50,
                        R.color.colorsapp_opacity_65,
                        R.color.colorsapp_opacity_80
                    )
                }

                /**Selección de la barra, y elección del tono guardado en el array*/
                when (selectedRadioButtonBar.text.toString()) {
                    /**Horizontales*/
                    getString(R.string.dialog_BarH1) -> cvH1.setCardBackgroundColor(
                        ContextCompat.getColor(this,
                            currentColor[0]
                        )
                    )

                    getString(R.string.dialog_BarH2) -> cvH2.setCardBackgroundColor(
                        ContextCompat.getColor(this,
                            currentColor[2]
                        )
                    )

                    getString(R.string.dialog_BarH3) -> cvH3.setCardBackgroundColor(
                        ContextCompat.getColor(this,
                            currentColor[4]
                        )
                    )

                    /**Verticales*/
                    getString(R.string.dialog_BarV1) -> verticalBars[0].colorSelected =
                        ContextCompat.getColor(this,currentColor[0])

                    getString(R.string.dialog_BarV2) -> verticalBars[1].colorSelected =
                        ContextCompat.getColor(this,currentColor[1])

                    getString(R.string.dialog_BarV3) -> verticalBars[2].colorSelected =
                        ContextCompat.getColor(this,currentColor[2])

                    getString(R.string.dialog_BarV4) -> verticalBars[3].colorSelected =
                        ContextCompat.getColor(this,currentColor[3])

                    getString(R.string.dialog_BarV5) -> verticalBars[4].colorSelected =
                        ContextCompat.getColor(this,currentColor[4])
                }
                updateBars()//Actualizamos barras
                dialog.hide()//Para que se cierre
            }
        }
        dialog.show()
    }
    fun updateBars() {//Notificar actualización
        rvColorsH.adapter?.notifyDataSetChanged()/**comprobamos nulidad */
        //rvAdapter.notifyDataSetChanged() /**En caso de ser nulo podría generar un NullPointerException*/

    }

}




/**
    private val verticalBars = mutableListOf(
        VerticalBar(871890688,"V1 (20%)"),
        VerticalBar(1509921024,"V2, (35%)"),
        VerticalBar(-2131230976,"V3, (50%)"),
        VerticalBar(-1509883935,"V4, ()"),
        VerticalBar(-85871793,"V5, ()"),
        )

}*/