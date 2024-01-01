package com.example.lesson_1111.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson_1111.domain.usecase.*
import com.example.lesson_1111.UiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class BulbViewModel @Inject constructor(
    private val getColorNamesUseCase: GetColorNamesUseCase,
    private val turnOnBulbUseCase: TurnOnBulbUseCase,
    private val turnOffBulbUseCase: TurnOffBulbUseCase,
    private val setColorUseCase: SetColorUseCase,
    private val setBrightnessUseCase: SetBrightnessUseCase,
    private val getBrightnessUseCase: GetBrightnessUseCase,
    private val getCurrentColorUseCase: GetCurrentColorUseCase,
    private val getBulbStateUseCase: GetBulbStateUseCase,
): ViewModel() {

    private val _colorNames = MutableLiveData<UiState<List<String>>>(UiState.Loading)
    private val _brightness = MutableLiveData<UiState<Int>>(UiState.Loading)
    private val _currentColorName = MutableLiveData<UiState<String>>(UiState.Loading)
    private val _bulbState = MutableLiveData<UiState<Boolean>>(UiState.Loading)

    val colorNames: LiveData<UiState<List<String>>>
        get() =
            _colorNames

    val brightness: LiveData<UiState<Int>>
        get() =
            _brightness

    val currentColorName : LiveData<UiState<String>>
        get() =
            _currentColorName

    val bulbState : LiveData<UiState<Boolean>>
        get() =
            _bulbState

    fun getColorNames() {
        viewModelScope.launch {
            val categoriesResult = getColorNamesUseCase()
            if (categoriesResult.isSuccess) {
                val categories = categoriesResult.getOrNull()
                categories ?: _colorNames.postValue(UiState.Failure("Data was null!"))
                _colorNames.postValue(categories?.let { UiState.Success(it) } ?: UiState.Failure("Data was null!"))
            } else _colorNames.postValue(
                UiState.Failure(categoriesResult.exceptionOrNull()?.message ?: "Very weird problems")
            )
        }
    }

    fun getCurrentColor() {
        viewModelScope.launch {
            val colorResult = getCurrentColorUseCase()
            if (colorResult.isSuccess) {
                val color = colorResult.getOrNull()?.color
                color ?: _currentColorName.postValue(UiState.Failure("Data was null!"))
                _currentColorName.postValue(color?.let { UiState.Success(it) } ?: UiState.Failure("Data was null!"))
            } else _currentColorName.postValue(
                UiState.Failure(colorResult.exceptionOrNull()?.message ?: "Very weird problems")
            )
        }
    }

    fun getBrightness() {
        viewModelScope.launch {
            val brightnessLevelResult = getBrightnessUseCase()
            if (brightnessLevelResult.isSuccess) {
                val brightnessLevel = brightnessLevelResult.getOrNull()
                brightnessLevel ?: _brightness.postValue(UiState.Failure("Data was null!"))
                _brightness.postValue(brightnessLevel?.let { UiState.Success(it) } ?: UiState.Failure("Data was null!"))
            } else _brightness.postValue(
                UiState.Failure(brightnessLevelResult.exceptionOrNull()?.message ?: "Very weird problems")
            )
        }
    }

    fun getBulbState() {
        viewModelScope.launch {
            val bulbStateResult = getBulbStateUseCase()
            if (bulbStateResult.isSuccess) {
                val bulbStateInfo = bulbStateResult.getOrNull()
                bulbStateInfo ?: _bulbState.postValue(UiState.Failure("Data was null!"))
                _bulbState.postValue(bulbStateInfo?.let { UiState.Success(it) } ?: UiState.Failure("Data was null!"))
            } else _bulbState.postValue(
                UiState.Failure(bulbStateResult.exceptionOrNull()?.message ?: "Very weird problems")
            )
        }
    }

    fun turnOnBulb() {
        viewModelScope.launch {
            turnOnBulbUseCase()
        }
    }

    fun turnOffBulb() {
        viewModelScope.launch {
            turnOffBulbUseCase()
        }
    }

    fun setColor(colorName: String) {
        viewModelScope.launch {
            setColorUseCase(colorName)
        }
    }

    fun setBrightness(brightnessLevel: Int) {
        viewModelScope.launch {
            setBrightnessUseCase(brightnessLevel)
        }
    }


}