package com.bessersolutions.bessertv.domain.usecases.DataStore

import com.bessersolutions.bessertv.domain.manger.LocalUserManger
import com.bessersolutions.bessertv.domain.model.UserModel

class SaveUser (
   private val localUserManger: LocalUserManger
){
   suspend operator fun  invoke(user:UserModel){
      localUserManger.saveUser(user)
   }
}