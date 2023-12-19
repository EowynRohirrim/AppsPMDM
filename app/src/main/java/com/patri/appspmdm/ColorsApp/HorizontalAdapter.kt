package com.patri.appspmdm.ColorsApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patri.appspmdm.R


/**El Adapter coge los objetos del item_vertical_bar, es decir, la lista que cuenta con los objetos verticalBar,
 * coge el layout de los objetos y se los pasa al View Holder, como listas por posiciones
 * y on create view holder le pasa el layout, recibe una posición y la pinta con la función render
y el otro le pasa la lista*/

class HorizontalAdapter(private val barras: List<VerticalBar>) :
    RecyclerView.Adapter<HorizontalViewHolder>() {

    /**Devuelve el item al View Holder por cada objeto de barra que haya
     * Crea la vista
     * ViewGroup o VerticalBar */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_vertical_bar, parent, false)
        return HorizontalViewHolder(view)
    }

    /**Pasa por cada uno de los objetos y llama al render (o pintarViews en esta caso)*/
    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.pintarViews(barras[position])
    }

    /**Devuelve el listado de barras */
    override fun getItemCount(): Int {
        return barras.size
    }

    /**El adapter se dedica a gestionar una clase principal por lo que se hace una variable
     * private val Barras:ListOf(
     *  y aquí dentro se le pasa una lista
     *
     *  se crean 5 objetos barra
     *  barra(azul,"")
     * )
     * */


}