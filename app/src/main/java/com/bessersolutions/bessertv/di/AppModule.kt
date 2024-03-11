package com.bessersolutions.bessertv.di

import android.app.Application
import com.bessersolutions.bessertv.data.manger.LocalUserMangerImpl
import com.bessersolutions.bessertv.domain.manger.LocalUserManger
import com.bessersolutions.bessertv.domain.usecases.XtreamApi.AppUserUseCase
import com.bessersolutions.bessertv.domain.usecases.XtreamApi.GetUser
import com.bessersolutions.bessertv.domain.usecases.XtreamApi.SaveUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}