package com.patri.appspmdm.VideoGameApp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService { //Interfaz

    //Co-Rutinas, deja hacer llamadas asincronas
    @GET("/games?key=6623ace5689e4af8b5376f9f817ef839&page_size=20&search=")
    //empiezan por suspend
    suspend fun getVideoGames(@Query("search") videogameName: String): Response<VideoGameDataResponse>


    /** la url global es hasta los asteriscos
     * https://api.rawg.io/api/*****games?key=   &page_size=20& search="query
     *
     * no funciona con path
     * hay que usar
     *
     * @Query
    *****/

    }*/
}