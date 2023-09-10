package com.ichwan.arch.apparchitecture.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private var _country = MutableLiveData("Indonesia")
    val country: LiveData<String> = _country

    fun saveCountry(newCountry: String){
        _country.value = newCountry
    }
}