package com.utsman.osmapp.retrofit

import org.json.JSONObject
import retrofit2.Response


sealed class AsyncResult<out T>{
    data class Error(val exception: Exception): AsyncResult<Nothing>()
    data class Succes<T>(val data: T): AsyncResult<T>()
}
fun <T> retrofitErrorHandler(res: Response<T>): T {
    if (res.isSuccessful) {
        return res.body()!!
    } else {
        val errMsg = res.errorBody()?.string()?.let {
            JSONObject(it).getString("error") // or whatever your message is
        } ?: run {
            res.code().toString()
        }

        throw Exception(errMsg)
    }
}