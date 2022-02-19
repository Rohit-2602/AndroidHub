package com.example.androidhub.network.response

import com.example.androidhub.model.network.User

data class ProfileResponse(
    val data: User,
    val successful: Boolean
)