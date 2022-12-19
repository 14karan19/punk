package com.punk.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.punk.db.PunkDB
import com.punk.repository.PunkRepository
import com.punk.viewmodels.HomeViewModel
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val repository: PunkRepository, private val punkDB: PunkDB): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}