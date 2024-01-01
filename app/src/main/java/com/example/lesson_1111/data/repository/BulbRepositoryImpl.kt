package com.example.lesson_1111.data.repository

import com.example.lesson_1111.data.api.BulbService
import com.example.lesson_1111.data.model.ColorModel
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject


class BulbRepositoryImpl @Inject constructor(
    private val service: BulbService
) : BulbRepository {
    override suspend fun turnOnBulb(): Result<Boolean?> {
        runCatching {
            service.turnOnBulb()
        }.fold(
            onSuccess = {
                return Result.success(it.body())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun turnOffBulb(): Result<Boolean?> {
        runCatching {
            service.turnOffBulb()
        }.fold(
            onSuccess = {
                return Result.success(it.body())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getBulbState(): Result<Boolean?> {
        runCatching {
            service.getBulbState()
        }.fold(
            onSuccess = {
                return Result.success(it.body())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getColorNames(): Result<List<String>?> {
        runCatching {
            service.getColorNames()
        }.fold(
            onSuccess = {
                if (it.isSuccessful)
                    return Result.success(it.body())
                else
                    return Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getCurrentColor(): Result<ColorModel?> {
        runCatching {
            service.getCurrentColor()
        }.fold(
            onSuccess = {
                return Result.success(it.body())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun setColor(colorName: String): Result<Boolean?> {
        runCatching {
            service.setColor(colorName)
        }.fold(
            onSuccess = {
                return Result.success(it.body())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun setBrightness(brightness: Int): Result<Boolean?> {
        runCatching {
            service.setBrightness(brightness)
        }.fold(
            onSuccess = {
                return Result.success(it.body())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getBrightness(): Result<Int?> {
        runCatching {
            service.getBrightness()
        }.fold(
            onSuccess = {
                return Result.success(it.body())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }
}