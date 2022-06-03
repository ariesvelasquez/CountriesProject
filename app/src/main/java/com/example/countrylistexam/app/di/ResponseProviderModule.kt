package com.example.countrylistexam.app.di

import android.content.Context
import com.example.countrylistexam.common.data.provider.ResponseProvider
import com.example.countrylistexam.country.data.provider.RestCountryResponseProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ResponseProviderModule {

    @Binds
    abstract fun restCountryResponseProvider(
        impl: RestCountryResponseProvider
    ) : ResponseProvider
}