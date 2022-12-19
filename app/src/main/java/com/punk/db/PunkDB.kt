package com.punk.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.punk.models.PunkBeer

@Database(entities = [PunkBeer::class], version = 1)
abstract class PunkDB : RoomDatabase() {

    abstract fun getPunkDAO() : PunkDao

}