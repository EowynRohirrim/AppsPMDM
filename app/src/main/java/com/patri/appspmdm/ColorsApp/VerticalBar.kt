package com.patri.appspmdm.ColorsApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.patri.appspmdm.R


data class VerticalBar(var colorSelected: Int, val label: String)

/** VerticalBar tiene que recibir dos parámetros:
 * colorSelected que es un entero
 *label que es un string
 *
 * recibirá 2 parámetros para poder crear objetos de una determinada categoría,
 * si ésta se encuentra seleccionada, y añadirlos a su lista correspondiente.
 * */

