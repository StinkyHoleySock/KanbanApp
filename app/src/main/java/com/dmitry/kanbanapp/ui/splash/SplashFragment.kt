package com.dmitry.kanbanapp.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dmitry.kanbanapp.R
import com.dmitry.kanbanapp.databinding.FragmentSplashBinding

private var _binding: FragmentSplashBinding? = null
private val binding get() = _binding!!

class SplashFragment: Fragment(R.layout.fragment_splash) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.stickerView.setOnClickListener {
            Toast.makeText(requireContext(), "Touched", Toast.LENGTH_SHORT).show()

            binding.splashFragment.transitionToEnd()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}