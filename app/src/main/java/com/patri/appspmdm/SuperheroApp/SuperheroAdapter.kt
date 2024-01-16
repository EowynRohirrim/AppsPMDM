package com.patri.appspmdm.SuperheroApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patri.appspmdm.R

/**Le vamos a pasar una lista
 * emptyList() la inicializamos vacía y ya haremos un update
 *
 */
class SuperheroAdapter(
    var superheroList: List<SuperheroItemResponse> = emptyList(),
    private val navigateToDetailActivity: (String) -> Unit) : RecyclerView.Adapter<SuperheroViewHolder>() {//funcion landa

    //recibe una lista para actualizar
    fun updateList(list: List<SuperheroItemResponse>) {
        superheroList = list
        notifyDataSetChanged()
    }

    //Coge el layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {

        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    //Crea una función que pinta las vistas
    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bind(superheroList[position],navigateToDetailActivity)

    }

    //Cuenta los elementos de la lista
    override fun getItemCount() = superheroList.size
}
