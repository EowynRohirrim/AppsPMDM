package com.patri.appspmdm.SuperheroApp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    /** INTERFAZ */

    /**Poner mi token*/
    @GET("/api/mi_token/search/{name}")
    /**el fragmento que tiene que añadir a la url base*/
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperHeroDataResponse>
    //la ruta que va a ir en esa variable es una cadena
    //y devuelve como respuesta una clase Response<SuperHer....>
    /**name es lo que se va a meter en la url
     *
     * LOS ID son STRINGS
     *
     * el get es una forma de pasar datos a través de un URL
     *
     *
     * La api nos devuelve un objeto, un elemento raiz
     * */

    //@GET("/api/10229233666327556/{id}")
    //suspend fun getSuperheroDetail(@Path("id") superheroId:String):Response<SuperHeroDetailResponse>


}