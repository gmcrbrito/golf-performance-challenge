package com.hole19golf.performance.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder {

    private var ourInstance: Retrofit ?= null

    val instance:Retrofit

        get(){
            if(ourInstance == null)
            {
                val httpClient = OkHttpClient().newBuilder()
                val interceptor = Interceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer viWFX8NNh42ngkdG1EQqVUeX83eD5GG6zBQQrwzHPktcxrpcRqRzRmPBWockfTx2 ")
                        .build()
                    chain.proceed(request)
                }
                httpClient.networkInterceptors().add(interceptor)

                ourInstance = Retrofit.Builder()
                    .baseUrl("https://h19-performance-challenge.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpClient.build())
                    .build()
            }
            return ourInstance!!
        }
}