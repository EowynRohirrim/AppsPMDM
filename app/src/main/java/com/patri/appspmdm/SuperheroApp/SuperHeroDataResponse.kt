package com.patri.appspmdm.SuperheroApp

import com.google.gson.annotations.SerializedName

//Este seria el nombre del objeto/elemento raiz
data class SuperHeroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperheroItemResponse>
)
/**RESPONSE es un elemento Strins
 * RESULTS es un array  de Strings
 * hay que convertir ese objeto en otra clase tenemos una clase por cada elemeto hijo
 * */


/************        SUBCLASES      **********
 *  Elementos dentro de la lista de RESULTS
 */
data class SuperheroItemResponse(
    @SerializedName("id") val superheroId: String,//Elementos dentro del array
    @SerializedName("name") val name: String,
    @SerializedName("image") val superheroImage: SuperheroImageResponse
)

/**Lo que está dentro del elemento image es un elemento url*/
data class SuperheroImageResponse(
    @SerializedName("url") val url: String
)

/**por cada objeto que haya hay que crear una data class
 * */
//Van a coger la clase que hemos diseñado para los elementos del recycler view