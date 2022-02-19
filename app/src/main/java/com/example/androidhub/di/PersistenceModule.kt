package com.example.androidhub.di

import android.content.Context
import androidx.room.Room
import com.example.androidhub.db.AndroidHubDatabase
import com.example.androidhub.preferences.DataStoreRepository
import com.example.androidhub.preferences.DataStoreRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): AndroidHubDatabase =
        Room.databaseBuilder(context, AndroidHubDatabase::class.java, "android_hub_database")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideUserDao(database: AndroidHubDatabase) =
        database.getUserDao()

    @Singleton
    @Provides
    fun provideDataStoreRepository(@ApplicationContext context: Context): DataStoreRepository =
        DataStoreRepositoryImpl(context = context)

}