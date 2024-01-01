package com.example.lesson_1111.data.api

import com.example.lesson_1111.data.model.ColorModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BulbService {
    @POST("state/on")
    suspend fun turnOnBulb(): Response<Boolean>

    @POST("state/off")
    suspend fun turnOffBulb(): Response<Boolean>

    @GET("state/")
    suspend fun getBulbState(): Response<Boolean>

    @GET("color/names_only")
    suspend fun getColorNames(): Response<List<String>>

    @GET("color/current")
    suspend fun getCurrentColor(): Response<ColorModel>

    @POST("color/")
    suspend fun setColor(@Query("color") colorName: String): Response<Boolean>

    @POST("brightness/")
    suspend fun setBrightness(@Query("level") brightness: Int): Response<Boolean>

    @GET("brightness/current")
    suspend fun getBrightness(): Response<Int>
}
