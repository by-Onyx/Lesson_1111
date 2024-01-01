package com.example.lesson_1111.domain.usecase

interface TurnOnBulbUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}