package com.example.countrylistexam.app.util

import android.content.Context
import android.os.Build
import android.provider.Settings
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SettingsUtil
@Inject
constructor(
    @ApplicationContext
    private val context: Context
) {

    fun getDefaultUserAgent() : String {
        return "${getUserAgent()} :${getDeviceName()}"
    }

    private fun getUserAgent() : String {
        return System.getProperty("http.agent") ?: ""
    }

    fun getDeviceName(): String =
        Settings.Global.getString(context.contentResolver, "device_name") ?: getDeviceNameIfNull()

    private fun getDeviceNameIfNull(): String {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        return if (model.startsWith(manufacturer)) {
            capitalize(model)
        } else
            "${capitalize(model)} $model"
    }

    private fun capitalize(str: String): String {
        return str.split(" ")
            .toMutableList()
            .apply {
                this.removeAll { it.isEmpty() }
            }.joinToString(" ") {
                it.capitalize()
            }
    }
}