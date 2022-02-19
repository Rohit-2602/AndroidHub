package com.example.androidhub.model.network

data class User(
    val userId: String,
    val username: String,
    val email: String,
    val bio: String,
    val profilePictureUrl: String,
    val bannerUrl: String?,
    val topSkills: List<String>,
    val followerCount: Int,
    val followingCount: Int,
    val postCount: Int,
    val articleCount: Int,
    val gitHubUrl: String?,
    val linkedInUrl: String?,
    val isOwnProfile: Boolean,
    val isFollowing: Boolean
)