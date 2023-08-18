package com.example.islamiapp.data.models.quran

import com.google.gson.annotations.SerializedName

data class SurahResponse(

    @SerializedName("data")
    val surahData: QuranData? = null

)
