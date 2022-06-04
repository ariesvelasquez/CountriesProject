package com.example.countrylistexam.core.common.domain.exception

import android.content.Context
import com.example.countrylistexam.R
import java.io.IOException

class NoConnectivityException(context: Context) :
    IOException(context.getString(R.string.error_no_internet_connection))