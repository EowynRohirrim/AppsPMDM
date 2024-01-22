package com.patri.appspmdm.VideoGameApp

import com.google.gson.annotations.SerializedName
import com.patri.appspmdm.SuperheroApp.SuperheroItemResponse

data class VideoGameDataResponse(
     @SerializedName("count") val count:String,
@SerializedName("results") val VideoGames: List<VideoGameItemResponse>
)

/************        SUBCLASES      **********
 *  Elementos dentro de la lista de RESULTS
 */
data class VideoGameItemResponse(
     @SerializedName("id") val VideoGameId: String,//Elementos dentro del array
     @SerializedName("name") val name: String, //Nombre
     @SerializedName("released") val date: String, //fecha de lanzamiento
     @SerializedName("platforms") val platform: VideoGamePlatformsResponse,
     @SerializedName("metacritic") val metacritic: Int, //Valoración (nota)
     @SerializedName("image") val VideoGameImage: VideoGameImageResponse //imagen
)

/**Lo que está dentro del elemento image es un elemento url*/
data class VideoGameImageResponse(
     @SerializedName("background_image") val url: String
)

//***********
data class VideoGamePlatformsResponse(
     @SerializedName("platform") val platform:String
)
