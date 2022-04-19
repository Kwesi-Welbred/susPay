package com.example.kotlin.repository.remote

import com.example.kotlin.di.app.App
import com.example.kotlin.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource {
    @Inject
    lateinit var ok: OkHttpClient

    fun <Api> buildApi(api: Class<Api>): Api {
        (App.instance as App).component
            .inject(this)

        // return this.remoteDataSource2
        return Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .client(ok)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}