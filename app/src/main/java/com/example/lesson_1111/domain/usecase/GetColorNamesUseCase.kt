package com.example.lesson_1111.domain.usecase

interface GetColorNamesUseCase {
    suspend operator fun invoke(): Result<List<String>?>
}