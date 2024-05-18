package com.utsman.osmapp.retrofit

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface RetroUserApi {
    @Headers("Accept: application/json")
    @GET("point/{id}")
    suspend fun getPointById(@Header("Authorization") token:String,@Path("id") id: Int):Point

    @Headers("Accept: application/json")
    @GET("points/1")
    suspend fun getPoint1():Point

    @Headers("Accept: application/json")
    @POST("login")
    suspend fun loginByNamePas(@Body loginRequest: LoginRequest):String

    @Headers("Accept: application/json")
    @POST("register")
    suspend fun registerUser(@Body registrationRequest: RegistrationRequest):String
}