package com.ichwan.arch.apparchitecture.bottomsheet

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ichwan.arch.apparchitecture.databinding.FragmentItemBinding

class ItemListDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentItemBinding? = null

    private val binding get() = _binding!!

    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}