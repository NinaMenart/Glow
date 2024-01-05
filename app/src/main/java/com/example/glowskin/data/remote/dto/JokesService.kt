package com.example.glowskin.data.remote.dto

interface JokesService {
    suspend fun getPosts(): List<PostResponse>
    suspend fun createPost(postRequest: PostRequest): PostResponse?
}