package com.patri.appspmdm.ColorsApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.patri.appspmdm.R

class HorizontalViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val tvVerticalBar: TextView = view.findViewById(R.id.tvVerticalBar)
    private val cvVerticalBar: CardView = view.findViewById(R.id.cvVerticalBar)


    fun render(verticalBar: VerticalBar){

        tvVerticalBar.text=verticalBar.texto
        cvVerticalBar.setCardBackgroundColor(verticalBar.colorSelected)

    }

    fun pintarViews(item: TextoEjemplo){
        tvVerticalBar.text = item.texto
        tvVerticalBar.setTextColor(item.colorTexto)
    }


}