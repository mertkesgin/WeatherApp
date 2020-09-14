package com.example.mertkesgin.weatherapp.di

import android.content.Context
import com.example.mertkesgin.weatherapp.data.local.UnitProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ProviderModule {

    @Singleton
    @Provides
    fun provideUnitProvider(
        @ApplicationContext context: Context
    ) = UnitProvider(context)
}