package com.bessersolutions.bessertv.domain.repository

import com.bessersolutions.bessertv.data.Result
import com.bessersolutions.bessertv.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface XtreamApiRepository {
    fun login(user:String,pass:String): Flow<Result<UserModel>>
}