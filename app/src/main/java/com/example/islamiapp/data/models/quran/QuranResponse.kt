package com.example.islamiapp.data.models.quran

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class QuranResponse(

    @SerializedName("data")
    val chapters: List<QuranData?>? = null

)

data class QuranData(

    @SerializedName("number")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("numberOfAyahs")
    val versesCount: Int? = null,

    val ayahs: List<AyahData?>? = null,

): Serializable

data class AyahData(

    @SerializedName("number")
    val id: Int? = null,

    @SerializedName("text")
    val ayah: String? = null,

    @SerializedName("numberInSurah")
    val ayahNumber: Int? = null

)
