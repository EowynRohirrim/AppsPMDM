package com.patri.appspmdm.BoardGamesApp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.patri.appspmdm.R
import com.patri.appspmdm.BoardGamesApp.Game.*


class GamesViewholder (view: View) : RecyclerView.ViewHolder(view) {

    private val tvGame: TextView = view.findViewById(R.id.tvGame)
    private val cbGame: CheckBox = view.findViewById(R.id.cbGame)
    private val cvGame: CardView = view.findViewById(R.id.cvGame)

    fun render(game: Game) {

        if (game.isSelected) {
            tvGame.paintFlags = tvGame.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvGame.paintFlags = tvGame.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        cbGame.isChecked = game.isSelected

        tvGame.text = game.name

        val color = when(game.category){
            GameCategory.Cooperative -> R.color.bgapp_cooperative_category
            GameCategory.Deckbuilding -> R.color.bgapp_deckbuilding_category
            GameCategory.Euro -> R.color.bgapp_euro_category
            GameCategory.LCG -> R.color.bgapp_lcg_category
            GameCategory.Legacy -> R.color.bgapp_legacy_category
        }

        cbGame.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(cbGame.context, color))
    }
}