package com.punk.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.punk.models.PunkBeer
import com.punk.repository.PunkRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: PunkRepository) : ViewModel() {

    val beersLiveData : LiveData<List<PunkBeer>>
    get() = repository.beers

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }

}