package com.example.islamiapp.uitls

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.data.enums.AppLanguage
import id.voela.actrans.AcTrans
import java.util.Locale

object HelperMethods {

    fun setLocal(activity: AppCompatActivity, language: AppLanguage) {
        val resources = activity.resources
        val metrics = resources.displayMetrics
        val configuration = resources.configuration
        val locale = Locale(language.local)
        Locale.setDefault(locale)
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, metrics)
        activity.onConfigurationChanged(configuration)
    }

    fun getLocale(context: Context): Locale {
        return context.resources.configuration.locales.get(0)
    }

    fun changeActivity(
        activity: AppCompatActivity, intent: Intent,
        isBack: Boolean = false, animation: Boolean = true, finishActivity: Boolean = true
    ) {
        activity.startActivity(intent)

        if (animation) {
            when (this.getLocale(activity).language) {
                "ar" -> {
                    if (isBack) AcTrans.Builder(activity).performSlideToLeft()
                    else AcTrans.Builder(activity).performSlideToRight()
                }
                else -> {
                    if (isBack) AcTrans.Builder(activity).performSlideToRight()
                    else AcTrans.Builder(activity).performSlideToLeft()
                }
            }
        }
        if (finishActivity) activity.finish()
    }

    fun createLog(text: String, isError: Boolean = false) {
        val tag = "LOG"
        if (text.length > 4000) {
            if (isError) {
                Log.e(tag, text.substring(0, 4000))
            } else {
                Log.d(tag, text.substring(0, 4000))
            }
            createLog(text.substring(4000), isError)
        } else {
            if (isError) {
                Log.e(tag, text)
            } else {
                Log.d(tag, text)
            }
        }
    }

}