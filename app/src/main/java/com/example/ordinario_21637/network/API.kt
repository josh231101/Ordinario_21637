package com.example.ordinario_21637.network

import com.example.ordinario_21637.models.Quote
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val URL_BASE = "https://api.chucknorris.io/jokes/" //Especificar la URL base de la API
    fun getRetrofitService(): APIInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: APIInterface = retrofit.create(APIInterface::class.java)
        return service
    }
}

class API {
    //Obtenemos un objeto retrofit, que nos ayudara a manejar las peticiones
    private val service = RetrofitHelper.getRetrofitService()

    //Función que nos permite obtener un post específico
    suspend fun getRandomJoke(): Quote {
        val response = service.getRandomJoke()
        return response
    }
}