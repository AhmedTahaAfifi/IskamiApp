package com.example.islamiapp.ui.fragments.quran.surah

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.islamiapp.R
import com.example.islamiapp.data.models.quran.SurahResponse
import com.example.islamiapp.data.requests.quranRequests.QuranRequests

class SurahViewModel: ViewModel() {

    val progressVisible = MutableLiveData<Boolean>()
    val responseLiveData = MutableLiveData<SurahResponse>()
    val errorLiveData = MutableLiveData<Int>()

    fun getSurah(surahNumber: Int?) {
        this.progressVisible.value = true
        QuranRequests.getSurah(surahNumber, {
            this.responseLiveData.value = it
            this.progressVisible.value = false
        }, {
            this.errorLiveData.value = R.string.something_went_wrong
            this.progressVisible.value = false
        })
    }

}