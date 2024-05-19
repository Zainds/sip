package com.utsman.osmapp.retrofit

data class MapPoint(
    val id:	String,
    var chunk_id: Int,
    var user_id: Int,
    var category_id: String,
    var updated_at:	String,
    var created_at: String,
    var latitude:Float,
    var longitude: Float

)
