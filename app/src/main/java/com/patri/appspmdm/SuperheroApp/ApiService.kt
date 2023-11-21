package com.patri.appspmdm.SuperheroApp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    /**Poner mi token*/
    @GET("/api/mi_token/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String): Response<SuperHeroDataResponse>
    //la ruta que va a ir en esa variable es una cadena
    //y devuelve como respuesta una clase


    //@GET("/api/10229233666327556/{id}")
    //suspend fun getSuperheroDetail(@Path("id") superheroId:String):Response<SuperHeroDetailResponse>



}