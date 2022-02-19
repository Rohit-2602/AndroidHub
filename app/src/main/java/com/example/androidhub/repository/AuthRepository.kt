package com.example.androidhub.repository

import com.example.androidhub.network.request.CreateAccountRequest
import com.example.androidhub.network.request.VerifyRequest
import com.example.androidhub.network.response.BasicApiResponse
import com.example.androidhub.network.service.AuthService
import com.example.androidhub.util.Resource
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authService: AuthService
) {

    suspend fun verifyFields(username: String, email: String): Resource<BasicApiResponse<Unit>> {
        val response = try {
            authService.verifyFields(VerifyRequest(email = email, username = username))
        } catch (exception: Exception) {
            return Resource.Error(message = exception.message!!.toString())
        }
        return Resource.Success(response)
    }

    suspend fun createUser(id: String, username: String, email: String): Resource<BasicApiResponse<Unit>> {
        val response = try {
            authService.createUser(CreateAccountRequest(id, email, username))
        } catch (exception: Exception) {
            return Resource.Error(message = exception.message!!.toString())
        }
        return Resource.Success(response)
    }

}