package com.example.islamiapp.data.requests.quranRequests

import com.example.islamiapp.data.models.quran.QuranResponse
import com.example.islamiapp.data.models.quran.SurahResponse
import com.example.islamiapp.data.requests.AppRetrofitRequest
import com.example.islamiapp.data.requests.RetrofitClient

object QuranRequests {

    private val retrofitClient = RetrofitClient.getInstants().quran()

    fun getChapters(onSuccess: (QuranResponse) -> Unit, onFail: () -> Unit) {
        retrofitClient.getChapters().enqueue(AppRetrofitRequest.getResponse({
            onSuccess(it)
        }, { _, _ ->
            onFail()
        }))
    }

    fun getSurah(surahId: Int?, onSuccess: (SurahResponse) -> Unit, onFail: () -> Unit) {
        retrofitClient.getSurah(surahId).enqueue(AppRetrofitRequest.getResponse({
            onSuccess(it)
        }, { _, _ ->
            onFail()
        }))
    }

}