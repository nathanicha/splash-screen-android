package com.example.nutlwd.splashscreen.module

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.akexorcist.localizationactivity.core.LanguageSetting.setLanguage
import com.chibatching.kotpref.Kotpref
import com.example.nutlwd.splashscreen.BuildConfig
import com.example.nutlwd.splashscreen.utils.SingletonUtils
import java.util.*
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    var context = this
    private var SPLASH_TIME_OUT = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nutlwd.splashscreen.R.layout.activity_splash)
        Kotpref.init(this)

        setLang()
        getVersionOfApp()
        onNavigationToMainActivity()
    }

    private fun getVersionOfApp() {
        var versionCode = BuildConfig.VERSION_CODE
        var versionName = BuildConfig.VERSION_NAME

        Log.d("version of application"," versionCode $versionCode \nversionName $versionName")
    }

    private fun onNavigationToMainActivity() {
//        val intent = Intent(context,MainActivity::class.java)
//        startActivity(intent)
//        finish()

        Handler().postDelayed({
            val intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    private fun setLang(){
        //first launch
        if(SingletonUtils.instance.firstLaunch){
            val lang = Locale.getDefault().language
            SingletonUtils.instance.languageCode = lang
            SingletonUtils.instance.firstLaunch = false

            val locale = Locale(lang)
            setLanguage(context,locale)
        }

    }


}
