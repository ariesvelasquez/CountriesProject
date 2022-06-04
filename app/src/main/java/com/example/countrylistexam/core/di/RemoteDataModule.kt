package com.example.countrylistexam.core.di

import com.example.countrylistexam.country.data.source.remote.CountryRemote
import com.example.countrylistexam.country.data.source.remote.rest_country_remote.impl.RestCountryRemoteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataModule {

    @Binds
    abstract fun restCountryRemote(impl: RestCountryRemoteImpl): CountryRemote
}