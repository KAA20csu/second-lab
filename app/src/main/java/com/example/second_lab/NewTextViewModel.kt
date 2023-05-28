package com.example.second_lab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewTextViewModel  @Inject constructor(
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