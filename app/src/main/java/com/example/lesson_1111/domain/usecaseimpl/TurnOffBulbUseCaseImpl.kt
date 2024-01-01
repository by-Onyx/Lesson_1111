package com.example.lesson_1111.domain.usecaseimpl

import com.example.lesson_1111.data.repository.BulbRepository
import com.example.lesson_1111.domain.usecase.TurnOffBulbUseCase
import javax.inject.Inject

class TurnOffBulbUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
) : TurnOffBulbUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.turnOffBulb()
}