package com.example.lesson_1111.domain.usecaseimpl

import com.example.lesson_1111.data.repository.BulbRepository
import com.example.lesson_1111.domain.usecase.SetColorUseCase
import javax.inject.Inject

class SetColorUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
) : SetColorUseCase {
    override suspend fun invoke(colorName: String): Result<Boolean?> =
        repository.setColor(colorName)
}