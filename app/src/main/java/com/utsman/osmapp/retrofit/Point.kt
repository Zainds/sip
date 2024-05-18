package com.utsman.osmapp.retrofit

data class Point(
    var is_house:String,
    var chunk_id: Int,
    var user_id: Int,
    var updated_at:	String,
    var created_at: String,
    val id:	String,
    var latitude:Float,
    var longitude: Float
)
