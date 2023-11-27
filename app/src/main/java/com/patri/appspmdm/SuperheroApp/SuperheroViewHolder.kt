package com.patri.appspmdm.SuperheroApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.patri.appspmdm.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

//Se le pasa un View que recib el RV
class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)//hace que enlace con ese layout

    //Recibe los item de la lista por posiciones
    fun bind(superheroItemResponse: SuperheroItemResponse, navigateToDetailActivity: (String) -> Unit) {//la flecha es de funcion landa
        binding.tvSuperheroName.text = superheroItemResponse.name //el texto que sea del item, pues el nombre
        Picasso.get().load(superheroItemResponse.superheroImage.url).into(binding.ivSuperhero)
        binding.root.setOnClickListener {//root es que coge todo el layout del item, da igual donde pinches del card view
            navigateToDetailActivity(superheroItemResponse.superheroId)//llamamos a la función de detalles
        }
        //Si fuese en el texto, sería binding.tvSuperheroName.setOnClickListener

    }
}
