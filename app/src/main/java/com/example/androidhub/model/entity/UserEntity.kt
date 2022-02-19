package com.example.androidhub.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey
    val userId: String,
    val username: String,
    val bio: String,
    val profilePictureUrl: String,
    val bannerUrl: String?,
    val topSkills: List<String>,
    val followerCount: Int,
    val followingCount: Int,
    val postCount: Int,
    val articleCount: Int,
    val gitHubUrl: String?,
    val linkedInUrl: String?
)
