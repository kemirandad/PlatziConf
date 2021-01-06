package com.example.conf.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.conf.model.Speaker
import com.example.conf.network.Callback
import com.example.conf.network.FirestoreService

class SpeakerViewModel {
        val firestoreService = FirestoreService()
        var listSpeakers: MutableLiveData<List<Speaker>> = MutableLiveData()
        var isLoading = MutableLiveData<Boolean>()

        fun refresh(){
            getSpeakersFromFirebase()
        }

        fun getSpeakersFromFirebase(){
            firestoreService.getSpeakers(object: Callback<List<Speaker>> {
                override fun onSuccess(result: List<Speaker>?) {
                    listSpeakers.postValue(result)
                    processFinished()
                }

                override fun onFailed(exception: Exception) {
                    processFinished()
                }
            })
        }

        fun processFinished(){
            isLoading.value = true
        }
    }