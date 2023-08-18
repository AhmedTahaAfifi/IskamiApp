package com.example.islamiapp.data.requests

import com.example.islamiapp.uitls.HelperMethods
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AppRetrofitRequest {

    fun <T> getResponse(
        onSuccess: (response: T) -> Unit, onFail: (responseCode: Int, message: String) -> Unit,
        onFailure: ((call: Call<T>, throwable: Throwable) -> Unit)? = null
    )
            :Callback<T>{
        return object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                when {
                    response.isSuccessful -> response.body()?.let { onSuccess(it) }
                    else -> {
                        HelperMethods.createLog("header: ${response.headers()}", true)
                        HelperMethods.createLog("code: ${response.code()}", true)
                        HelperMethods.createLog("message: ${response.message()}", true)
                        onFail(response.code(), response.message())
                    }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                onFailure?.let { it(call, t) }
                HelperMethods.createLog("onFailure: ${t.message.toString()}", true)
            }

        }
    }

}