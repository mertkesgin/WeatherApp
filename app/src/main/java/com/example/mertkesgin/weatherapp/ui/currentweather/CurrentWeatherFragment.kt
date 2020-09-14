package com.example.mertkesgin.weatherapp.ui.currentweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mertkesgin.weatherapp.R
import com.example.mertkesgin.weatherapp.databinding.FragmentCurrentWeatherBinding
import com.example.mertkesgin.weatherapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentWeatherFragment : Fragment(R.layout.fragment_current_weather) {

    private val currentViewModelCurrent: CurrentWeatherViewModel by viewModels()

    private var _binding: FragmentCurrentWeatherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentCurrentWeatherBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCurrentWeatherObserver()
    }

    private fun setupCurrentWeatherObserver() {
        currentViewModelCurrent.currentWeather.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success ->{
                    response.data?.let{
                        binding.currentWeather = it
                        hideProgress()
                    }
                }
                is Resource.Error ->{
                    Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
                    hideProgress()
                }
                is Resource.Loading ->{
                    showProgress()
                }
            }
        })
    }

    fun showProgress(){
        binding.progressBar.visibility = View.VISIBLE
    }

    fun hideProgress(){
        binding.progressBar.visibility = View.INVISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}