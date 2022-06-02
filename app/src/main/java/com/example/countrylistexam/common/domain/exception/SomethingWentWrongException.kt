package com.example.countrylistexam.common.domain.exception

import android.content.Context
import com.example.countrylistexam.R
import java.io.IOException

class SomethingWentWrongException(context: Context, message: String? = null) :
    IOException(message ?: context.getString(R.string.error_something_went_wrong))