package com.patri.appspmdm.ColorsApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.patri.appspmdm.R

class HorizontalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    /**Los atributos de la barra vertical*/
    private val tvVerticalBar: TextView = view.findViewById(R.id.tvVerticalBar)//Texto
    private val cvVerticalBar: CardView = view.findViewById(R.id.cvVerticalBar)//Color

    /**Recibe los objetos y los pinta (es la funcion render)*/
    fun pintarViews(verticalBar: VerticalBar) {

        /**Comparar las barras para decidir que pintar y dónde*/
        when (verticalBar.label) {
            "V1 20%".toString() -> {
                tvVerticalBar.text = "V1 20%"
                cvVerticalBar.setCardBackgroundColor(verticalBar.colorSelected)
            }
            "V2 35%".toString() -> {
                tvVerticalBar.text = "V2 35%"
                cvVerticalBar.setCardBackgroundColor(verticalBar.colorSelected)
            }
            "V3 50%".toString() -> {
                tvVerticalBar.text = "V3 50%"
                cvVerticalBar.setCardBackgroundColor(verticalBar.colorSelected)
            }
            "V4 65%".toString() -> {
                tvVerticalBar.text =  "V4 65%"
                cvVerticalBar.setCardBackgroundColor(verticalBar.colorSelected)
            }
            "V5 80%".toString() -> {
                tvVerticalBar.text = "V5 80%"
                cvVerticalBar.setCardBackgroundColor(verticalBar.colorSelected)
            }
        }
    }
}