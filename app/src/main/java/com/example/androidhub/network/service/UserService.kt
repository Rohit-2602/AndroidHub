package com.example.androidhub.network.service

import com.example.androidhub.network.response.ProfileResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("user/profile")
    suspend fun getUserProfile(
        @Query("userId") userId: String,
        @Query("callerId") currentUserId: String
    ): ProfileResponse

}