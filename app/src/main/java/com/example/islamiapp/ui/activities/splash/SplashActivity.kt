package com.example.islamiapp.ui.activities.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.islamiapp.databinding.ActivitySplashBinding
import com.example.islamiapp.ui.activities.ParentActivity
import com.example.islamiapp.ui.activities.main.MainActivity
import com.example.islamiapp.uitls.HelperMethods

@SuppressLint("CustomSplashScreen")
class SplashActivity : ParentActivity() {

    private lateinit var binding: ActivitySplashBinding

    private val delayMilliSec: Long = 2000 // 2sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.startCountDown()
    }

    private fun startCountDown() {
        Handler(Looper.getMainLooper()).postDelayed({
            this.nextActivity()
        }, this.delayMilliSec)
    }

    private fun nextActivity() {
        val intent = Intent(this, MainActivity::class.java)
        HelperMethods.changeActivity(this, intent)
    }
}