package com.example.countrylistexam.country.domain.exception

import android.content.Context
import com.example.countrylistexam.R
import java.io.IOException

class SomeApiSpecificException(context: Context, message: String? = null) :
    IOException(message ?: context.getString(R.string.app_name))