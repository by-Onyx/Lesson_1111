package com.example.lesson_1111.di

import com.example.lesson_1111.presentation.BulbFragment
import dagger.Component
import dagger.Module

@Component(
    modules = [
        AppModule::class,
    ]
)
interface AppComponent {
    fun inject(fragment: BulbFragment)
}


@Module(
    includes = [
        NetworkModule::class,
        ViewModelModule::class,
        AppBindsModule::class
    ]
)
class AppModule {

}