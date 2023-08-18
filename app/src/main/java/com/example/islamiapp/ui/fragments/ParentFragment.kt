package com.example.islamiapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.islamiapp.data.interfaces.Navigator
import com.example.islamiapp.ui.activities.main.MainActivity
import com.example.islamiapp.ui.fragments.quran.surah.SurahFragment

open class ParentFragment: Fragment(), Navigator {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.hideBottomNavigationView()

    }

    override fun navigate(action: NavDirections) {
        this.findNavController().navigate(action)
    }

    override fun popBackStake() {
        this.findNavController().popBackStack()
    }

    fun setToolbarTitle(title: String?) {
        (activity as? MainActivity)?.supportActionBar?.title = title
    }

    private fun hideBottomNavigationView() {
        if (this is SurahFragment) {
            (activity as? MainActivity)?.hideBottomNavigationView(true)
        } else {
            (activity as? MainActivity)?.hideBottomNavigationView(false)
        }
    }

}