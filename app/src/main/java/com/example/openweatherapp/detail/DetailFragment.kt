package com.example.openweatherapp.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.openweatherapp.R
import com.example.openweatherapp.databinding.FragmentDetailBinding


/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class DetailFragment : Fragment() {
    lateinit var viewModel: DetailViewModel
    lateinit var viewModelFactory: DetailViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDetailBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        val detailFragmentArgs by navArgs<DetailFragmentArgs>()

        viewModelFactory = DetailViewModelFactory(detailFragmentArgs.weatherItem)
        viewModel = ViewModelProvider(this, viewModelFactory)[(DetailViewModel::class.java)]
        binding.viewModel = viewModel

        return binding.root
    }
}