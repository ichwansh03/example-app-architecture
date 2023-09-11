package com.ichwan.arch.apparchitecture.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun changeName(currentName: String): String {
        return currentName
    }
}