package com.example.lesson_1111.domain.usecase

import com.example.lesson_1111.data.model.ColorModel

interface GetCurrentColorUseCase {
    suspend operator fun invoke(): Result<ColorModel?>
}