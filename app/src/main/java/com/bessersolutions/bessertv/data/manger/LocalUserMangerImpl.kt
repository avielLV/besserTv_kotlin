package com.bessersolutions.bessertv.data.manger

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.bessersolutions.bessertv.domain.manger.LocalUserManger
import com.bessersolutions.bessertv.domain.model.UserModel
import com.bessersolutions.bessertv.utils.Constant
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserMangerImpl (
    private val context:Context
):LocalUserManger{
    private val gson = Gson()

    override suspend fun saveUser(user: UserModel) {
        val userJson = gson.toJson(user)
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.USER_LOCAL] = userJson
        }
    }

    override fun getUser(): Flow<UserModel> {
        return context.dataStore.data.map { preferences->
          val userJson =  preferences[PreferencesKeys.USER_LOCAL]
            gson.fromJson(userJson,UserModel::class.java)
        }
    }
}
private val readOnlyProperty = preferencesDataStore(Constant.USER_SETTINGS)

val Context.dataStore: DataStore<Preferences> by readOnlyProperty
private object PreferencesKeys {
    val USER_LOCAL = stringPreferencesKey(Constant.USER_LOCAL)
}