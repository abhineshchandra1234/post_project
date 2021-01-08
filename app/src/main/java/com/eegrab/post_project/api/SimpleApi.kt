package com.eegrab.post_project.api

import com.abhinesh.getretrofit.model.Post
import com.eegrab.post_project.model.Post1
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SimpleApi {

    @FormUrlEncoded
    @POST("check_access.php")
    suspend fun pushPost3(
        @Field("code") code: String,
        @Field("type") type: String
    ): Response<Post1>
}