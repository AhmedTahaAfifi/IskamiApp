package com.example.islamiapp.ui.fragments

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.islamiapp.data.interfaces.Navigator
import com.example.islamiapp.uitls.appNavigation.AppNavigation

open class ParentFragment: Fragment(), Navigator {

    override fun navigate(action: NavDirections) {
        this.findNavController().navigate(action, AppNavigation.navOption)
    }

    override fun popBackStake() {
        this.findNavController().popBackStack()
    }

}