package com.utsman.osmapp.retrofit

data class RegistrationRequest(
    val name: String,
    val password: String,
    var email:String,
    var age: Int,
    var gender: Boolean
)
data class LoginRequest(
    var name: String,
    var password: String
)