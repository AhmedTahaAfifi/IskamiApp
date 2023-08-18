package com.example.islamiapp.data.requests

import com.example.islamiapp.data.requests.quranRequests.QuranRequestsInterface
import com.example.islamiapp.uitls.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private val httpClient = OkHttpClient.Builder().addInterceptor(Interceptor {
        val original: Request = it.request()
        val requestBuilder = original.newBuilder()
        requestBuilder.method(original.method(), original.body())
        val request = requestBuilder.build()

        return@Interceptor it.proceed(request)
    })
    private val client = this.httpClient.readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private var instant: RetrofitClient? = null

    fun getInstants(): RetrofitClient {
        if (instant == null) {
            instant = RetrofitClient
        }

        return instant!!
    }

    fun quran(): QuranRequestsInterface {
        return retrofit.create(QuranRequestsInterface::class.java)
    }

}