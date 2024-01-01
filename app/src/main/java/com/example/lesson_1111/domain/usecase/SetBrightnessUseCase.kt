package com.example.lesson_1111.domain.usecase

interface SetBrightnessUseCase {
    suspend operator fun invoke(brightness: Int): Result<Boolean?>
}