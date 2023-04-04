package com.example.enidemo.api

import com.example.enidemo.api.ChuckService.Companion.retrofit
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ChuckService {
    // singleton
    companion object {
        // URL de l'API
        val BASE_URL = "https://api.chucknorris.io/jokes/"
        // utilitaire permettant de mapper automatiquement le Json en objet
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        // utilitaire retrofit
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    // lien avec l'URL
    @GET("random")
    suspend fun randomFact(): Joke
}

// appel au service
object ChuckApi {
    val retrofitService: ChuckService by lazy { retrofit.create(ChuckService::class.java) }

}