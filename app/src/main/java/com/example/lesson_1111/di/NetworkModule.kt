package com.example.lesson_1111.di

import com.example.lesson_1111.data.api.BulbService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @Provides
    fun provideLampService() : BulbService =
        Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build())
            .baseUrl("http://195.54.14.121:8086/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(BulbService::class.java)
}