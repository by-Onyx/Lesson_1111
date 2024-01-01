package com.example.lesson_1111.domain.usecaseimpl

import com.example.lesson_1111.data.repository.BulbRepository
import com.example.lesson_1111.domain.usecase.TurnOnBulbUseCase
import javax.inject.Inject

class TurnOnBulbUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
) : TurnOnBulbUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.turnOnBulb()
}