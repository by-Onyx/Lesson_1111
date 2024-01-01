package com.example.lesson_1111.domain.usecase

interface GetBulbStateUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}