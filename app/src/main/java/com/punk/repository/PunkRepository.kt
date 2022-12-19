package com.punk.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.punk.PunkApplication
import com.punk.db.PunkDB
import com.punk.models.PunkBeer
import com.punk.retrofit.PunkAPI
import com.punk.utils.CommonUtil
import javax.inject.Inject

class PunkRepository @Inject constructor(private val punkAPI: PunkAPI, private val punkDB: PunkDB) {

    private val _beers = MutableLiveData<List<PunkBeer>>()
    val beers: LiveData<List<PunkBeer>>
    get() = _beers

    suspend fun getProducts(){

        if (CommonUtil.isConnectingToInternet(PunkApplication.context!!)){
            val result = punkAPI.getBeers()

            if(result.isSuccessful && result.body() != null){
                punkDB.getPunkDAO().addBeers(result.body()!!)
                _beers.postValue(result.body())
            }
        }else{
            _beers.postValue(punkDB.getPunkDAO().getBeers())
        }
    }
}