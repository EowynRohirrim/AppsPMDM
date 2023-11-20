package com.patri.appspmdm.BoardGamesApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patri.appspmdm.R

class GamesAdapter(var games: List<Game>, private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<GamesViewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return GamesViewholder(view)
    }

    override fun onBindViewHolder(holder: GamesViewholder, position: Int) {
        holder.itemView.setOnClickListener{ onItemSelected(position) }
        holder.render(games[position])
    }

    override fun getItemCount() = games.size
}