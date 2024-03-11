package com.bessersolutions.bessertv.domain.manger

import com.bessersolutions.bessertv.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface LocalUserManger {

    suspend fun saveUser(user:UserModel)

    fun getUser(): Flow<UserModel?>
}