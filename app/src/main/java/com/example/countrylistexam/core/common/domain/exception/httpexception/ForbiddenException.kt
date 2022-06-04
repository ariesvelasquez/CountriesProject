package com.example.countrylistexam.core.common.domain.exception.httpexception

import android.content.Context
import com.example.countrylistexam.R
import java.io.IOException

class ForbiddenException(context: Context, message: String? = null) :
    IOException(message ?: context.getString(R.string.error_forbidden))