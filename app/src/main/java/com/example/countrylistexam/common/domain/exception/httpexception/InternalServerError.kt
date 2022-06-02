package com.example.countrylistexam.common.domain.exception.httpexception

import android.content.Context
import com.example.countrylistexam.R
import java.io.IOException

class InternalServerError(context: Context, message: String? = null) :
    IOException(message ?: context.getString(R.string.error_internal_server_error))