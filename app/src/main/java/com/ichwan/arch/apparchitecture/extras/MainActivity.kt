package com.ichwan.arch.apparchitecture.extras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ichwan.arch.apparchitecture.databinding.ActivityMainBinding
import com.ichwan.arch.apparchitecture.parcelables.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.apply {
            buttonMove.setOnClickListener {
                val intent = Intent(this@MainActivity, DataActivity::class.java)
                intent.putExtra(DataActivity.EXTRA_NAME, "Ichwan Sholihin")
                intent.putExtra(DataActivity.EXTRA_AGE, 22)
                startActivity(intent)
            }

            buttonMoveParcelable.setOnClickListener {
                val user = User("Ichwan Sholihin", 22, "ichwansholihin03@gmail.com","Bandarlampung")

                val intent = Intent(this@MainActivity, DataActivity::class.java)
                intent.putExtra(DataActivity.EXTRA_USER, user)
                startActivity(intent)
            }
        }

        setContentView(binding.root)
    }
}