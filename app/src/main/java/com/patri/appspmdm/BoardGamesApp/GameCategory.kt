package com.patri.appspmdm.BoardGamesApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.patri.appspmdm.R

sealed class GameCategory(var isSelected:Boolean = true) {
    object Deckbuilding : GameCategory()
    object Euro : GameCategory()
    object LCG : GameCategory()
    object Cooperative : GameCategory()
    object Legacy : GameCategory()
}