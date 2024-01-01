package com.example.lesson_1111.domain.usecaseimpl

import com.example.lesson_1111.data.repository.BulbRepository
import com.example.lesson_1111.domain.usecase.GetBrightnessUseCase
import com.example.lesson_1111.domain.usecase.GetBulbStateUseCase
import javax.inject.Inject

class GetBrightnessUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
) : GetBrightnessUseCase {
    override suspend fun invoke(): Result<Int?> =
        repository.getBrightness()
}