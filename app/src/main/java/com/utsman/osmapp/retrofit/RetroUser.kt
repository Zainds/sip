package com.utsman.osmapp.retrofit

data class RegistrationRequest(
    val name: String,
    val password: String,
    var email:String,
    var age: Int,
    var gender: Boolean,
    var about_me: String
)
data class LoginRequest(
    var email: String,
    var password: String
)
data class PointRequest(
    var latitude: String,
    var longitude: String
)