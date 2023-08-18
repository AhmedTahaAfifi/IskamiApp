package com.example.islamiapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Disable dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

}