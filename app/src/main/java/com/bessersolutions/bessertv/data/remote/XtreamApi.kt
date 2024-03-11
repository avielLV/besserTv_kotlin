package com.bessersolutions.bessertv.data.remote

import com.bessersolutions.bessertv.domain.model.UserModel
import retrofit2.http.GET
import retrofit2.http.Query

interface XtreamApi {

    @GET()
    suspend fun login(
        @Query("username")user:String,
        @Query("password")pass:String
    ):UserModel
}