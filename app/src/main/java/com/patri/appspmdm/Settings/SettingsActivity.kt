package com.patri.appspmdm.Settings

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.patri.appspmdm.R
import com.patri.appspmdm.databinding.ActivityDetailVideoGameBinding
import com.patri.appspmdm.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsActivity : AppCompatActivity() {

    companion object {
        const val VOLUME_LVL = "volume_lvl"
        const val KEY_BLUETOOTH = "key_bluetooth"
        const val KEY_VIBRATION = "key_vibration"
        const val KEY_DARK_MODE = "key_dark_mode"
    }


    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings") //Context es como this.
    //Utilizamos "by" en vez de "=" para generar una única instancia de la clase (singleton) (que solo se puede instanciar una vez con el by)
    //Como nos hace falta una lista clave valor tenemos una DataStore <> que se va a llamar settings

    //Por cada app que creamos generamos un biding
    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    //Funcion para el range slider
    //El comando dataStore.edit debe ir dentro de una corrutina (suspend)
    //El range slider devuelve un float no un entero
    private suspend fun saveVolume(value: Int) {
        dataStore.edit {preferences ->//edit lo que hace es entrar al atributo preferencias del datastore donde se almacenan valores
            preferences[intPreferencesKey(VOLUME_LVL)] = value
            //intPreferencesKey le va a poner un elemento a it, a este elemento, se va a internar leer la clave lvl de volume
            //Va a ser la lista preferencias con su clave lvl volume que le llega por parámetro
        }
    }

    //Funcion para el range slider
    private fun initUI() {//aquí ponemostodo o que va a ver el usuario

        //Volumen
        binding.rsVolume.addOnChangeListener { _, value, _ -> //el valor es un long
            Log.i("Volumen", "El valor es $value") //Para comprobar en el logcat los datos del rangeslider
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt())
            }
        }

        //Switchs
        binding.switchBluetooth.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_BLUETOOTH, value)
            }
        }
        binding.switchVibration.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_VIBRATION, value)
            }
        }

        //Switchs modo oscuro
        binding.switchDarkMode.setOnCheckedChangeListener { _, value ->
            if(value){
                enableDarkMode()
            }else{
                disableDarkMode()
            }
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_DARK_MODE, value)
            }
        }
    }

    //Funcion para los switchs
    private suspend fun saveOptions(key: String, value: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
        }
    }

    //Funciones para el modo oscuro
    private fun enableDarkMode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        delegate.applyDayNight()
    }
    private fun disableDarkMode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()
    }


}