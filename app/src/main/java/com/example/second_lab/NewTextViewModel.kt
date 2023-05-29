package com.example.second_lab

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewTextViewModel @Inject constructor(
    private val useCase: UseCaseInterface
): ViewModel() {
    private val _models = MutableLiveData<List<ReceiveModel>>()
    val newText: LiveData<List<ReceiveModel>> = _models

    fun loadNewText() {
        viewModelScope.launch {
            val response = useCase.getModels()
            if (response != null) {
                _models.postValue(response)
            }
        }
    }
}
class NewTextViewModelFactory @Inject constructor(private val useCase: UseCaseInterface) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewTextViewModel(useCase) as T
    }
}