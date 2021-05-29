package com.vicbarkfeld.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vicbarkfeld.santanderdevweek.data.Conta
import com.vicbarkfeld.santanderdevweek.data.local.FakeData

class MainViewModel : ViewModel() {
    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente() : LiveData<Conta> {
        FakeData().getLocalData().also { it.also { mutableLiveData.value  } }

        return mutableLiveData
    }
}