package com.utsman.osmapp.retrofit

data class Point(
    var TYPE_FILTER_WORK_IN_PROGRESS:String,
    var chunk_id: Int,
    var user_id: Int,
    var updated_at:	String,
    var created_at: String,
    val id:	String,

    var latitude:	Long,
    var longitude: Long
)
