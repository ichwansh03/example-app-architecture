package com.ichwan.arch.apparchitecture.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.ichwan.arch.apparchitecture.R
import com.ichwan.arch.apparchitecture.databinding.ActivityLiveBinding

class LiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveBinding
    private val model: NameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameObserver = Observer<String> { newName ->
            binding.txname.text = model.changeName(newName)
        }

        model.currentName.observe(this, nameObserver)
    }
}