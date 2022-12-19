package com.punk.di

import android.content.Context
import androidx.room.Room
import com.punk.db.PunkDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providePunkDB(context : Context) : PunkDB {
        return Room.databaseBuilder(context, PunkDB::class.java, "PunkDB").build()
    }
}