package com.hole19golf.performance.data.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder {

    private var ourInstance: Retrofit ?= null

    val instance:Retrofit

        get(){
            if(ourInstance == null)
            {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                val httpClient = OkHttpClient().newBuilder()
                val interceptor = Interceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer viWFX8NNh42ngkdG1EQqVUeX83eD5GG6zBQQrwzHPktcxrpcRqRzRmPBWockfTx2 ")
                        .build()
                    chain.proceed(request)
                }
                httpClient.networkInterceptors().add(interceptor)
                httpClient.addInterceptor(httpLoggingInterceptor)

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