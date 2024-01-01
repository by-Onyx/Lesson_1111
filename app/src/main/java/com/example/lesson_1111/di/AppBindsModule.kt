package com.example.lesson_1111.di

import com.example.lesson_1111.data.repository.*
import com.example.lesson_1111.domain.usecase.*
import com.example.lesson_1111.domain.usecaseimpl.*
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {
    @Binds
    fun bindSampleRepository(repository: BulbRepositoryImpl): BulbRepository

    @Binds
    fun getColorNamesUseCase(useCase: GetColorNamesUseCaseImpl) : GetColorNamesUseCase

    @Binds
    fun setBrightnessUseCase(useCase: SetBrightnessUseCaseImpl) : SetBrightnessUseCase

    @Binds
    fun setColorUseCase(useCase: SetColorUseCaseImpl) : SetColorUseCase

    @Binds
    fun turnOffBulbUseCase(useCase: TurnOffBulbUseCaseImpl) : TurnOffBulbUseCase

    @Binds
    fun turnOnBulbUseCase(useCase: TurnOnBulbUseCaseImpl) : TurnOnBulbUseCase

    @Binds
    fun getBulbStateUseCase(useCase: GetBulbStateUseCaseImpl) : GetBulbStateUseCase

    @Binds
    fun getCurrentColorUseCase(useCase: GetCurrentColorUseCaseImpl) : GetCurrentColorUseCase

    @Binds
    fun getBrightnessUseCase(useCase: GetBrightnessUseCaseImpl) : GetBrightnessUseCase
}