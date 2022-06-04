package com.example.countrylistexam.core.di

import android.content.Context
import com.example.countrylistexam.BuildConfig
import com.example.countrylistexam.core.util.SettingsUtil
import com.example.countrylistexam.core.common.data.remote.retrofit.interceptor.ConnectivityInterceptor
import com.example.countrylistexam.core.common.data.remote.retrofit.interceptor.UserAgentInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @ApplicationContext
        context: Context,
        settingsUtil: SettingsUtil
    ): OkHttpClient {
        val builder: OkHttpClient.Builder =
            OkHttpClient.Builder()
                .addInterceptor(ConnectivityInterceptor(context))
                .addInterceptor(UserAgentInterceptor(settingsUtil.getDefaultUserAgent()))

        builder.apply {
            readTimeout(120, TimeUnit.SECONDS)
            writeTimeout(120, TimeUnit.SECONDS)

            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(loggingInterceptor)
            }
        }

        builder.cache(null)
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideRestAdapter(
        okHttpClient: OkHttpClient
    ) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }
}