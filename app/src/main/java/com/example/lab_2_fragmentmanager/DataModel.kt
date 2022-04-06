package com.example.lab_2_fragmentmanager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
    val username: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val password: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val showEditFragment: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val firstname: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val lastname: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val middlename: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val university: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val faculty: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val course: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}