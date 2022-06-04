package com.example.countrylistexam.core.common.data.remote.retrofit.interceptor

import android.content.Context
import android.net.ConnectivityManager
import com.example.countrylistexam.core.common.domain.exception.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!hasConnection()) {
            throw NoConnectivityException(context)
        }
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    private fun hasConnection() : Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val actionNetwork = connectivityManager.activeNetworkInfo
        return actionNetwork != null && actionNetwork.isConnectedOrConnecting
    }
}