package com.example.mertkesgin.weatherapp.ui.fivedaysweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mertkesgin.weatherapp.R
import com.example.mertkesgin.weatherapp.adapters.FiveDaysWeatherAdapter
import com.example.mertkesgin.weatherapp.databinding.FragmentFiveDaysWeatherBinding
import com.example.mertkesgin.weatherapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class FiveDaysWeatherFragment : Fragment(R.layout.fragment_five_days_weather) {

    val viewModel:FiveDaysWeatherViewModel by viewModels()

    private var _binding:FragmentFiveDaysWeatherBinding? = null
    private val binding get() = _binding!!

    private lateinit var fiveDaysWeatherAdapter: FiveDaysWeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFiveDaysWeatherBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupFiveDaysWeatherObserver()
    }

    private fun setupFiveDaysWeatherObserver() {
        viewModel.fiveDaysWeather.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success -> {
                    response.data?.let {
                        fiveDaysWeatherAdapter.differ.submitList(it.list.reversed())
                    }
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), response.message, Toast.LENGTH_LONG).show()
                    Timber.d(response.message)
                }
                is Resource.Loading ->{

                }
            }
        })
    }

    private fun setupRecyclerView() {
        fiveDaysWeatherAdapter = FiveDaysWeatherAdapter()
        binding.rvFiveDaysWeather.apply {
            adapter = fiveDaysWeatherAdapter
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}