package com.example.openweatherapp.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.example.openweatherapp.adapter.WeatherItemAdapter
import com.example.openweatherapp.adapter.WeatherItemListener
import com.example.openweatherapp.database.WeatherItemDatabase
import com.example.openweatherapp.databinding.FragmentOverviewBinding
import com.example.openweatherapp.repository.Repository
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 * Use the [OverviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OverviewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOverviewBinding.inflate(inflater)
        val repository = Repository(WeatherItemDatabase.getDatabase(this.requireContext()))
        val viewModelFactory = OverviewViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory)[OverViewViewModel::class.java]
        val weatherItemAdapter = WeatherItemAdapter(WeatherItemListener {
            Navigation.findNavController(binding.root)
                .navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))
        })

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.weatherItemAdapter = weatherItemAdapter

        setHasOptionsMenu(true)
        return binding.root
    }

}