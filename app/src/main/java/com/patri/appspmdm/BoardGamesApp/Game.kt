package com.patri.appspmdm.BoardGamesApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

data class Game (val name:String, val category: GameCategory, var isSelected:Boolean = false)