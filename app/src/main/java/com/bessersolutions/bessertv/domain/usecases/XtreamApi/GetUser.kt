package com.bessersolutions.bessertv.domain.usecases.XtreamApi

import com.bessersolutions.bessertv.domain.manger.LocalUserManger
import com.bessersolutions.bessertv.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

class GetUser(
  private val  localUserManger: LocalUserManger
) {
    operator fun invoke():Flow<UserModel?>{
        return localUserManger.getUser();
    }
}