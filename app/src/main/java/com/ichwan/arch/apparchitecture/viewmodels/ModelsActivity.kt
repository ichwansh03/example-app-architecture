package com.ichwan.arch.apparchitecture.viewmodels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.ichwan.arch.apparchitecture.R
import com.ichwan.arch.apparchitecture.databinding.ActivityModelsBinding

class ModelsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModelsBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.main_container)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}