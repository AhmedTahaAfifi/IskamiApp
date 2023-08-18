package com.example.islamiapp.data.requests.quranRequests

import com.example.islamiapp.data.models.quran.QuranResponse
import com.example.islamiapp.data.models.quran.SurahResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface QuranRequestsInterface {

    @GET("surah")
    fun getChapters(): Call<QuranResponse>

    @GET("surah/{surah}")
    fun getSurah(@Path("surah") surahId: Int?): Call<SurahResponse>

}