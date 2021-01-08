package com.eegrab.post_project.repository

import com.abhinesh.getretrofit.model.Post
import com.eegrab.post_project.api.RetrofitInstance
import com.eegrab.post_project.model.Post1
import retrofit2.Response

class Repository {

    suspend fun pushPost3(code: String, type: String): Response<Post1> {
        return RetrofitInstance.api.pushPost3(code,type)
    }
}