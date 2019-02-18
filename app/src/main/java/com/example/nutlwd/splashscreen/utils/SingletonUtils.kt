package com.example.nutlwd.splashscreen.utils

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.chibatching.kotpref.Kotpref
import com.chibatching.kotpref.KotprefModel

import com.example.nutlwd.splashscreen.constants.BaseConstants

class SingletonUtils: KotprefModel {

    var firstLaunch: Boolean by booleanPref(true, BaseConstants.firstLaunch)
    var languageCode: String by stringPref("en",BaseConstants.languageCode)

    private var mPrefs: SharedPreferences? = null
    private constructor(){
        mPrefs = ApplicationContextor.instance.context?.getSharedPreferences("PREFS_NAME",MODE_PRIVATE)
    }

    companion object {
        val instance: SingletonUtils by lazy { SingletonUtils() }
    }
}