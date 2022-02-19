package com.example.androidhub.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.androidhub.db.converters.SkillsConverter
import com.example.androidhub.db.dao.UserDao
import com.example.androidhub.model.entity.UserEntity

@Database(entities = [UserEntity::class], exportSchema = true, version = 1)
@TypeConverters(value = [SkillsConverter::class])
abstract class AndroidHubDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao

}