package com.example.mertkesgin.weatherapp.ui.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.mertkesgin.weatherapp.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.settings)
    }

}