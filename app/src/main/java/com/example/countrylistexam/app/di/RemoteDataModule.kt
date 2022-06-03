package com.example.countrylistexam.app.di

import com.example.countrylistexam.country.data.source.remote.CountryRemote
import com.example.countrylistexam.country.data.source.remote.client.RestCountryApiClient
import com.example.countrylistexam.country.data.source.remote.impl.CountryRemoteImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataModule {

    @Binds
    abstract fun restCountry(impl: CountryRemoteImpl): CountryRemote
}