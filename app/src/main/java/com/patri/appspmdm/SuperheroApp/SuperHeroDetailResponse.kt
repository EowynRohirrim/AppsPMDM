package com.patri.appspmdm.SuperheroApp

import com.google.gson.annotations.SerializedName

data class SuperHeroDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStatsResponse,
    @SerializedName("image") val image: SuperheroImageDetailResponse,
    @SerializedName("biography") val biography:Biography
)

data class PowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,//Ponerle una ? al final para nombres nulables¿?¿?
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)


data class SuperheroImageDetailResponse(@SerializedName("url") val url:String)


data class Biography(
    @SerializedName("full-name") val fullName:String,
    @SerializedName("publisher") val publisher:String
)

//Lo que hay entre paréntesis en verde tiene que ser exactamente igual que en el json
