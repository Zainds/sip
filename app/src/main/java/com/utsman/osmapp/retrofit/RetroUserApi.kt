package com.utsman.osmapp.retrofit

import retrofit2.Response
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
    @GET("point/1")
    suspend fun getPoint1():Point

    @Headers("Accept: application/json")
    @POST("login")
    fun loginByNamePas(@Body loginRequest: LoginRequest):String

    @Headers("Accept: application/json")
    @POST("registration")
    suspend fun registerUser(@Body registrationRequest: RegistrationRequest):String

    @Headers("Accept: application/json")
    @POST("point/nearest")
    suspend fun getNearestPoint(@Body pointRequest: PointRequest): List<MapPoint>
}