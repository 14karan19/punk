package com.punk.retrofit

import com.punk.models.PunkBeer
import retrofit2.Response
import retrofit2.http.GET

interface PunkAPI {

    @GET("beers")
    suspend fun getBeers() : Response<List<PunkBeer>>
}