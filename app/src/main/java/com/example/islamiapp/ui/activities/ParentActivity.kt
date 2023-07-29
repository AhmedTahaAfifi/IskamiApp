package com.example.islamiapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.data.enums.AppLanguage
import com.example.islamiapp.ui.activities.splash.SplashActivity
import com.example.islamiapp.uitls.HelperMethods

open class ParentActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (this is SplashActivity) {
            HelperMethods.setLocal(this, AppLanguage.ARABIC)
        }
    }
}