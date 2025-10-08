package com.example.a1news

data class Post(
    val id: Int,
    val title: String,
    val content: String,
    val imageUrl: String,
    val isLiked: Boolean = false,
    val isBookmarked: Boolean = false
)
