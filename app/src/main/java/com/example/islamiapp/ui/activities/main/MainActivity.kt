package com.example.islamiapp.ui.activities.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.islamiapp.databinding.ActivityMainBinding
import com.example.islamiapp.ui.activities.ParentActivity
import com.example.islamiapp.uitls.extensions.hide
import com.example.islamiapp.uitls.extensions.show

class MainActivity : ParentActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

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
        this.navController = navHost.navController

        // navGraph
        this.setupActionBarWithNavController(this.navController)

        // bottomNavigationView
        binding.bottomNavigation.setupWithNavController(this.navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return this.navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun hideBottomNavigationView(isHide: Boolean) {
        if (isHide) {
            binding.bottomNavigation.hide()
        } else {
            binding.bottomNavigation.show()
        }
    }

}