package com.example.islamiapp.uitls.appNavigation

import androidx.navigation.NavOptions
import com.example.islamiapp.R

object AppNavigation {

    val navOption = NavOptions.Builder()
        .setEnterAnim(R.anim.nav_slide_left)
        .setExitAnim(R.anim.nav_wait)
        .setPopEnterAnim(R.anim.nav_wait)
        .setPopExitAnim(R.anim.nav_slide_right)
        .build()

}