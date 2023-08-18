package com.example.islamiapp.ui.fragments.quran.quran

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.islamiapp.R
import com.example.islamiapp.data.interfaces.Navigator
import com.example.islamiapp.data.models.quran.QuranData
import com.example.islamiapp.data.models.quran.QuranResponse
import com.example.islamiapp.data.requests.quranRequests.QuranRequests

class QuranViewModel: ViewModel() {

    val progressVisible = MutableLiveData<Boolean>()
    val responseLiveData = MutableLiveData<QuranResponse>()
    val errorLiveData = MutableLiveData<Int>()

    var navigator: Navigator? = null

    fun getChapters() {
        this.progressVisible.value = true
        QuranRequests.getChapters({
            this.responseLiveData.value = it
            this.progressVisible.value = false
        }, {
            this.errorLiveData.value = R.string.something_went_wrong
            this.progressVisible.value = false
        })
    }

    fun goToSurahFragment(quranData: QuranData) {
        val action = QuranFragmentDirections.actionQuranFragmentToSurahFragment(quranData)
        this.navigator?.navigate(action)
    }

}