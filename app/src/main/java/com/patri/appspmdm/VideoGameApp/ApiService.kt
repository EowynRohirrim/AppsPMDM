package com.patri.appspmdm.VideoGameApp

import com.patri.appspmdm.SuperheroApp.SuperHeroDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService { //Interfaz

    //Co-Rutinas, deja hacer llamadas asincronas
    @GET("games?key=6623ace5689e4af8b5376f9f817ef839&page_size=10") //comprobar la barra
    //empiezan por suspend
    suspend fun getVideoGames(@Query("search") videoGameName: String): Response<VideoGameDataResponse>

    /** la url global es hasta los asteriscos
     * https://api.rawg.io/api/*****games?key=   &page_size=20& search="query
     *
     * no funciona con path
     * hay que usar
     *
     * @Query
    *****/

    }*/


    @GET("/games?key=6623ace5689e4af8b5376f9f817ef839/{id}")
    suspend fun getVideoGameDetail(@Path("id") VideoGameId:String):Response<VideoGameDetailResponse>

}