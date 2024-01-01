package com.example.lesson_1111.domain.usecase

interface GetBrightnessUseCase {
    suspend operator fun invoke(): Result<Int?>
}