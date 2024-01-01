package com.example.lesson_1111.domain.usecase

interface SetColorUseCase {
    suspend operator fun invoke(colorName: String): Result<Boolean?>
}