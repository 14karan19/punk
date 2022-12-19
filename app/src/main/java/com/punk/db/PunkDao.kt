package com.punk.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.punk.models.PunkBeer

@Dao
interface PunkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBeers(punkBeers : List<PunkBeer>)

    @Query("SELECT * FROM PunkBeer")
    suspend fun getBeers() : List<PunkBeer>

}