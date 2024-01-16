package com.patri.appspmdm.VideoGameApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.patri.appspmdm.SuperheroApp.SuperheroItemResponse
import com.patri.appspmdm.databinding.ItemSuperheroBinding
import com.patri.appspmdm.databinding.ItemVideogameBinding
import com.squareup.picasso.Picasso

class VideoGameViewHolder (view: View) : RecyclerView.ViewHolder(view)  {

    private val binding = ItemVideoGameBinding.bind(view)//hace que enlace con ese layout

    //Recibe los item de la lista por posiciones
    fun bind(VideoGameItemResponse: VideoGameItemResponse, navigateToDetailActivity: (String) -> Unit) {//la flecha es de funcion landa
        binding.tvVideoGameName.text = VideoGameItemResponse.name //el texto que sea del item, pues el nombre
        Picasso.get().load(VideoGameItemResponse.VideoGameImage.url).into(binding.ivVideoGame) //Funcion de la libreria Picasso


        binding.root.setOnClickListener {//root es que coge todo el layout del item, da igual donde pinches del card view
            navigateToDetailActivity(VideoGameItemResponse.VideoGameId)//nos llevamos la id a la siguiente actividad
        }
        //Si fuese en el texto, sería binding.tvSuperheroName.setOnClickListener

    }
}