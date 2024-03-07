package com.codelamps.newsapp.dependency

import android.app.Application
import com.codelamps.newsapp.data.manager.LocalUserManagerImpl
import com.codelamps.newsapp.domain.manager.LocalUserManager
import com.codelamps.newsapp.domain.usecase.AppEntryUseCases
import com.codelamps.newsapp.domain.usecase.ReadAppEntry
import com.codelamps.newsapp.domain.usecase.SaveAppEntry
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
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}