package com.eegrab.post_project.model

data class Post1 (
    val code: String,
    val type: String,
    val message: String,
    val user: ArrayList<User>
)