package com.example.modernandroidarchitectures.networking

import com.example.modernandroidarchitectures.model.Country
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesApi {

    @GET("all")
    fun getCountries(): Single<List<Country>>

    @GET("name/{name}")
    fun getCountry(@Path("name") name: String): Single<Country>
}