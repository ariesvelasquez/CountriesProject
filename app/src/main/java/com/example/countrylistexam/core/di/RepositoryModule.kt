package com.example.countrylistexam.core.di

import com.example.countrylistexam.country.data.repository.CountryRepositoryImpl
import com.example.countrylistexam.country.domain.repository.CountryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideCountryRepository(
        impl: CountryRepositoryImpl
    ) : CountryRepository
}