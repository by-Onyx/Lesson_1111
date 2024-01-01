package com.example.lesson_1111.domain.usecase

interface TurnOffBulbUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}