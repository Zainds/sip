package com.utsman.osmapp.retrofit

import retrofit2.http.GET

interface RetroUserApi {
    @GET("points/1")
    fun getPointById():Point
}