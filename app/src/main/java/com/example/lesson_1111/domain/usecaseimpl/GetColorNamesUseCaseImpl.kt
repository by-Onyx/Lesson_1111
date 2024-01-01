package com.example.lesson_1111.domain.usecaseimpl

import com.example.lesson_1111.data.repository.BulbRepository
import com.example.lesson_1111.domain.usecase.GetColorNamesUseCase
import javax.inject.Inject

class GetColorNamesUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
): GetColorNamesUseCase
{
    override suspend fun invoke(): Result<List<String>?> =
        repository.getColorNames()
}