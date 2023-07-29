package com.example.islamiapp.data.interfaces

import androidx.navigation.NavDirections

interface Navigator {

    fun navigate(action: NavDirections)

    fun popBackStake()

}