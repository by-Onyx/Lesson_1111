package com.example.lesson_1111.domain.usecaseimpl

import com.example.lesson_1111.data.repository.BulbRepository
import com.example.lesson_1111.domain.usecase.SetBrightnessUseCase
import javax.inject.Inject

class SetBrightnessUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
): SetBrightnessUseCase
{
    override suspend fun invoke(brightness: Int): Result<Boolean?> =
        repository.setBrightness(brightness)
}