package com.example.glowskin.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse (
        val joke: String,
        val id: Int,
        val userId: Int,
        )