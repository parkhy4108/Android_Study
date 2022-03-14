package com.devyoung.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private var _currentValue = MutableLiveData<Int>()
    // livedata

    val currentValue : LiveData<Int>
        get() = _currentValue

    init {
        _currentValue.value = 0
    }

    fun plusvalue(){
        _currentValue.value = _currentValue.value?.plus(1)
    }

    fun minusvalue(){
        _currentValue.value = _currentValue.value?.minus(1)
    }

}

