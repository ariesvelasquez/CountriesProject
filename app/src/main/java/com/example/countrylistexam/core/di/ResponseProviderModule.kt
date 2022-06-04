package com.example.countrylistexam.core.di

import com.example.countrylistexam.core.common.data.provider.ResponseProvider
import com.example.countrylistexam.country.data.provider.RestCountryResponseProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ResponseProviderModule {

    @Binds
    abstract fun restCountryResponseProvider(
        impl: RestCountryResponseProvider
    ) : ResponseProvider
}