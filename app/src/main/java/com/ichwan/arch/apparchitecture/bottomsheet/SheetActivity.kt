package com.ichwan.arch.apparchitecture.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ichwan.arch.apparchitecture.R
import com.ichwan.arch.apparchitecture.databinding.ActivitySheetBinding

class SheetActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySheetBinding
    private var itemListDialogFragment = ItemListDialogFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomSheet.setOnClickListener {
            itemListDialogFragment.show(supportFragmentManager,ItemListDialogFragment.TAG)
        }
    }
}