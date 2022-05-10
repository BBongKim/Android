package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConvertViewModel : ViewModel() {
    private val won_to_usd_rate = 1276.0;
    private val _result = MutableLiveData<Double>()
    var won = MutableLiveData<String>()

    init {
        _result.value = 0.0
    }

    val result: LiveData<Double>
        get() = _result

    fun convert() {
        _result.value =
            if (won.value == "") 0.0 else won.value.toString().toDouble() / won_to_usd_rate
    }
}