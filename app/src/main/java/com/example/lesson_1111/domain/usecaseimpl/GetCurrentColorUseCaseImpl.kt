package com.example.lesson_1111.domain.usecaseimpl

import com.example.lesson_1111.data.model.ColorModel
import com.example.lesson_1111.data.repository.BulbRepository
import com.example.lesson_1111.domain.usecase.GetCurrentColorUseCase
import javax.inject.Inject

class GetCurrentColorUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
) : GetCurrentColorUseCase {
    override suspend fun invoke(): Result<ColorModel?> =
        repository.getCurrentColor()
}