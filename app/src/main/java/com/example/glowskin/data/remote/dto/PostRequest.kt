package com.example.glowskin.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest (
        val joke: String,
        )