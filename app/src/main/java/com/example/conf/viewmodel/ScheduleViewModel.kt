package com.example.conf.viewmodel

import com.example.conf.model.Conference
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.conf.network.Callback
import com.example.conf.network.FirestoreService
import java.lang.Exception

class ScheduleViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listSchedule: MutableLiveData<List<Conference>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getScheduleFromFirebase()
    }

    fun getScheduleFromFirebase(){
        firestoreService.getSchedule(object: Callback<List<Conference>> {
            override fun onSuccess(result: List<Conference>?) {
                listSchedule.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    private fun processFinished() {
        isLoading.value = true
    }
}