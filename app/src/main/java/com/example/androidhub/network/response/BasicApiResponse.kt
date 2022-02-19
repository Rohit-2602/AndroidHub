package com.example.androidhub.network.response

data class BasicApiResponse<T>(
    val message: String,
    val successful: Boolean,
    val data: T? = null
)