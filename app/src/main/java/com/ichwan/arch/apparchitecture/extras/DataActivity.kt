package com.ichwan.arch.apparchitecture.extras

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ichwan.arch.apparchitecture.databinding.ActivityDataBinding
import com.ichwan.arch.apparchitecture.parcelables.User

class DataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBinding

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"

        //parcelable
        const val EXTRA_USER = "extra_user"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE,0)

        binding.txreceived.text = "My name is $name and i'm $age years old"

        getDataParcelable()
    }

    @SuppressLint("SetTextI18n")
    private fun getDataParcelable() {
        val user = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_USER, User::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_USER)
        }

        binding.txreceivedParcelable.text = "My name is ${user?.name}\n, " +
                "i'm ${user?.age},\n" +
                "my email is ${user?.email},\n" +
                "and i live in ${user?.city}"
    }
}