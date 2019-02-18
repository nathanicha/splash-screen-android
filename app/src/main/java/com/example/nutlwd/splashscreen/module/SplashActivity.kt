package com.example.nutlwd.splashscreen.module

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.akexorcist.localizationactivity.core.LanguageSetting.setLanguage
import com.chibatching.kotpref.Kotpref
import com.example.nutlwd.splashscreen.R
import com.example.nutlwd.splashscreen.base.BaseActivity
import com.example.nutlwd.splashscreen.utils.SingletonUtils
import java.util.*

class SplashActivity : AppCompatActivity() {

    var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Kotpref.init(this)

        setLang()
        onNavigationToMainActivity()
    }

    private fun onNavigationToMainActivity() {
        val intent = Intent(context,MainActivity::class.java)
        startActivity(intent)
        finish()
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
