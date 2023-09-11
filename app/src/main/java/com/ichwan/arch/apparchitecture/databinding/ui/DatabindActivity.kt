package com.ichwan.arch.apparchitecture.databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ichwan.arch.apparchitecture.R
import com.ichwan.arch.apparchitecture.databinding.ActivityDatabindBinding
import com.ichwan.arch.apparchitecture.databinding.data.EventHandler
import com.ichwan.arch.apparchitecture.databinding.data.User

class DatabindActivity : AppCompatActivity() {

    lateinit var binding: ActivityDatabindBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_databind)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_databind)

        binding.user = User("Ichwan Sholihin","ichwansholihin03@gmail.com","080808")

        binding.handler = EventHandler(this)
    }
}