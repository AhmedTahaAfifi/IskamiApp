package com.example.islamiapp.data.enums

import com.example.islamiapp.R

enum class AppLanguage(val local: String, val title: Int) {
    ENGLISH("en", R.string.english),
    ARABIC("ar", R.string.arabic);

    companion object {
        fun getLocal(local: String): AppLanguage {
            for (item in values()) {
                if (item.local == local) return item
            }

            return ENGLISH
        }
    }
}