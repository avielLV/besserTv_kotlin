package com.bessersolutions.bessertv.data.repository

import com.bessersolutions.bessertv.data.Result
import com.bessersolutions.bessertv.data.remote.XtreamApi
import com.bessersolutions.bessertv.domain.model.UserModel
import com.bessersolutions.bessertv.domain.repository.XtreamApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class XtreamApiRepositoryImpl @Inject constructor(
    private val api:XtreamApi
):XtreamApiRepository{
    override fun login(user: String, pass: String): Flow<Result<UserModel>> = flow{
        emit(Result.Loading())
        try {
            val response = api.login(user, pass)
            emit(Result.Success(response))
        }catch (e:HttpException){
            emit(Result.Error(
                message = "Error al logear",
                data = null
            ))
        }catch (e: IOException){
            emit(Result.Error(
                message = "Error con el servidor",
                data = null
            ))
        }
    }
}