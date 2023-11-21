package com.patri.appspmdm.SuperheroApp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse {

    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperheroItemResponse>
    /**Los resultados es un array
     * hay que convertir ese objeto en otra clase
     * tenemos una clase por cada elemeto hijo
     * */
}

/**     Subclases   */
data class SuperheroItemResponse(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val superheroImage:SuperheroImageResponse
)
data class SuperheroImageResponse(@SerializedName("url") val url:String)

//Van a coger la clase que hemos diseñado para los elementos del recycler view