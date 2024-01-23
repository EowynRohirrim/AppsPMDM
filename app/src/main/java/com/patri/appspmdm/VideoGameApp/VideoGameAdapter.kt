package com.patri.appspmdm.VideoGameApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patri.appspmdm.R

class VideoGameAdapter (

    var VideoGameList: List<VideoGameItemResponse> = emptyList(), //Lista de videojuegos, inicializada a vacio
    private val navigateToDetailActivity: (String) -> Unit) : RecyclerView.Adapter<VideoGameViewHolder>() {//funcion landa

    //recibe una lista para actualizar
    fun updateList(List<VideoGameItemResponse>) {
        this.VideoGameList = VideoGameList
        notifyDataSetChanged()
    }

    //Coge el layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoGameViewHolder {

        return VideoGameViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_videogame, parent, false)
        )
    }

    //Crea una función que pinta las vistas
    override fun onBindViewHolder(holder: VideoGameViewHolder, position: Int) {
        holder.bind(VideoGameList[position], navigateToDetailActivity)

    }

    //Cuenta los elementos de la lista
    override fun getItemCount() = VideoGameList.size

}