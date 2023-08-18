package com.example.islamiapp.view.snackBar

import android.view.View
import com.example.islamiapp.R
import com.google.android.material.snackbar.Snackbar

class AppSnackBar(view: View, textRes: Int = 0, type: Type = Type.NORMAL, isLong: Boolean = false) {

    init {
        val duration = if (isLong) Snackbar.LENGTH_LONG else Snackbar.LENGTH_SHORT
        val snackBar = if (textRes != 0) {
            Snackbar.make(view, textRes, duration)
        } else {
            Snackbar.make(view, "", duration)
        }

        val backgroundTint = when(type) {
            Type.SUCCESS -> view.context.getColor(R.color.gold)
            Type.ERROR -> view.context.getColor(R.color.red)
            Type.NORMAL -> null
        }
        backgroundTint?.let { snackBar.setBackgroundTint(it) }

        snackBar.setTextColor(view.context.getColor(R.color.white))
        snackBar.animationMode = Snackbar.ANIMATION_MODE_SLIDE
        snackBar.show()
    }

    enum class Type {
        SUCCESS, ERROR, NORMAL
    }
}