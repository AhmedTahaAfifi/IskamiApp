package com.example.islamiapp.ui.activities.main

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.islamiapp.databinding.ActivityMainBinding
import com.example.islamiapp.ui.activities.ParentActivity

class MainActivity : ParentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.setupView()
    }

    private fun setupView() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""

        val navHost = supportFragmentManager.findFragmentById(binding.fragmentContainer.id) as NavHostFragment

        // navGraph
        this.setupActionBarWithNavController(navHost.navController)

        // bottomNavigationView
        binding.bottomNavigation.setupWithNavController(navHost.navController)

    }

}