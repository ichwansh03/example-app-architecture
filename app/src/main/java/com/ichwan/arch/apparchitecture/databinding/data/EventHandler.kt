package com.ichwan.arch.apparchitecture.databinding.data

import android.content.Context
import android.widget.Toast

class EventHandler(private var context: Context){
    fun onClickButton(message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}