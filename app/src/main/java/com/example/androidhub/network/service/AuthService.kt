package com.example.androidhub.network.service

import com.example.androidhub.network.request.CreateAccountRequest
import com.example.androidhub.network.request.VerifyRequest
import com.example.androidhub.network.response.BasicApiResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("user/verify")
    suspend fun verifyFields(
        @Body request: VerifyRequest
    ): BasicApiResponse<Unit>

    @POST("user/create")
    suspend fun createUser(
        @Body request: CreateAccountRequest
    ): BasicApiResponse<Unit>

}