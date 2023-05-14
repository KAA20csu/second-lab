package com.example.second_lab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NewTextViewModel: ViewModel() {

    private val _models = MutableLiveData<ReceiveModel>()
    val newText: LiveData<ReceiveModel> = _models

    fun loadNewText() {
        viewModelScope.launch {
            val response = RetrofitClient.jsonApi.getModels()
            if (response.isSuccessful) {
                _models.postValue(response.body())
            }
        }
    }
}