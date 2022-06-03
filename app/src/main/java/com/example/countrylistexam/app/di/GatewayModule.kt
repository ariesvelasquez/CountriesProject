package com.example.countrylistexam.app.di

import com.example.countrylistexam.common.data.provider.ResponseProvider
import com.example.countrylistexam.country.data.gateway.CountryGatewayImpl
import com.example.countrylistexam.country.data.source.remote.CountryRemote
import com.example.countrylistexam.country.domain.gateway.CountryGateway
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GatewayModule {

    @Binds
    abstract fun provideCountryGateWay(
        impl: CountryGatewayImpl
    ) : CountryGateway
}