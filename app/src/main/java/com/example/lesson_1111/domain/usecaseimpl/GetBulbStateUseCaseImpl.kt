package com.example.lesson_1111.domain.usecaseimpl

import com.example.lesson_1111.data.repository.BulbRepository
import com.example.lesson_1111.domain.usecase.GetBulbStateUseCase
import javax.inject.Inject

class GetBulbStateUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
) : GetBulbStateUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.getBulbState()
}