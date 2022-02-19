package com.example.androidhub.repository

import com.example.androidhub.db.dao.UserDao
import com.example.androidhub.model.entity.UserEntity
import com.example.androidhub.network.response.ProfileResponse
import com.example.androidhub.network.service.UserService
import com.example.androidhub.util.Resource
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserService,
    private val userDao: UserDao
) {

    suspend fun getUserProfile(currentUserId: String, userId: String): Resource<ProfileResponse> {
        val response = try {
            userService.getUserProfile(userId = userId, currentUserId = currentUserId)
        } catch (exception: Exception) {
            return Resource.Error(message = exception.message!!.toString())
        }
        return Resource.Success(response)
    }

    suspend fun insertUserToDB(user: UserEntity) = userDao.insertUser(user)

}