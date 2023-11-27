package com.patri.appspmdm.SuperheroApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.patri.appspmdm.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

//Se le pasa un View que recib el RV
class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)//hace que enlace con ese layout

    //Recibe los item de la lista por posiciones
    fun bind(superheroItemResponse: SuperheroItemResponse) {
        binding.tvSuperheroName.text = superheroItemResponse.name //el texto que sea del item, pues el nombre
        Picasso.get().load(superheroItemResponse.superheroImage.url).into(binding.ivSuperhero)
    }
}
