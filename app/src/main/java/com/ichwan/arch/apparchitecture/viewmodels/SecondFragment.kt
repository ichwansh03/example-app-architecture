package com.ichwan.arch.apparchitecture.viewmodels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ichwan.arch.apparchitecture.R
import com.ichwan.arch.apparchitecture.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        sharedViewModel.country.observe(viewLifecycleOwner) { country ->
            binding.messageInput.setText(country)
        }

        binding.submit.setOnClickListener {
            sharedViewModel.saveCountry(binding.messageInput.text.toString())
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

        return binding.root
    }

}