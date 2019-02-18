package com.example.nutlwd.splashscreen.utils

import android.content.Context

class ApplicationContextor {
    var context: Context? = null

    companion object {
        val instance: ApplicationContextor by lazy { ApplicationContextor() }
    }

}