package com.example.ordinario_21637.network

import com.example.ordinario_21637.models.Quote
import retrofit2.http.GET
import retrofit2.http.Path

interface APIInterface {

    //Para la peticion GET, definimos el path relativo al endpoint
    @GET("random/")
    suspend fun getRandomJoke(): Quote //Nuestro endpoint devuelve una lista de posts, por eso usamos List

}