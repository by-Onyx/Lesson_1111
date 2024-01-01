package com.example.lesson_1111.data.repository

import com.example.lesson_1111.data.model.ColorModel
import retrofit2.Response
import retrofit2.http.GET

interface BulbRepository {
    suspend fun turnOnBulb(): Result<Boolean?>
    suspend fun turnOffBulb(): Result<Boolean?>
    suspend fun getBulbState(): Result<Boolean?>
    suspend fun getColorNames(): Result<List<String>?>
    suspend fun getCurrentColor(): Result<ColorModel?>
    suspend fun setColor(colorName: String): Result<Boolean?>
    suspend fun setBrightness(brightness: Int): Result<Boolean?>
    suspend fun getBrightness(): Result<Int?>
}