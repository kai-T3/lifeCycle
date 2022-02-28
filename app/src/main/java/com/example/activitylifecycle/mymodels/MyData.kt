package com.example.activitylifecycle.mymodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyData: ViewModel() {
    //mutablelive = reflex on changes
    var name = MutableLiveData<String>()
    var age = MutableLiveData<Int>()


}