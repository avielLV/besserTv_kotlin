package com.bessersolutions.bessertv.di

import android.app.Application
import com.bessersolutions.bessertv.data.manger.LocalUserMangerImpl
import com.bessersolutions.bessertv.data.remote.XtreamApi
import com.bessersolutions.bessertv.data.repository.XtreamApiRepositoryImpl
import com.bessersolutions.bessertv.domain.manger.LocalUserManger
import com.bessersolutions.bessertv.domain.repository.XtreamApiRepository
import com.bessersolutions.bessertv.domain.usecases.DataStore.AppUserUseCase
import com.bessersolutions.bessertv.domain.usecases.DataStore.GetUser
import com.bessersolutions.bessertv.domain.usecases.DataStore.SaveUser
import com.bessersolutions.bessertv.domain.usecases.XtreamApi.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ):LocalUserManger = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppUserUseCase(
        localUserManger: LocalUserManger
    )= AppUserUseCase(
        getUser = GetUser(localUserManger),
        saveUser = SaveUser(localUserManger)
    )

    @Provides
    @Singleton
    fun provideXtreamApi():XtreamApi{
        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(XtreamApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(
        xtreamApi: XtreamApi
    ):XtreamApiRepository = XtreamApiRepositoryImpl(xtreamApi)

    @Provides
    @Singleton
    fun provideLoginUserCase(
        xtreamApiRepository: XtreamApiRepository
    ):LoginUseCase {
        return LoginUseCase(
            xtreamApiRepository
        )
    }

}