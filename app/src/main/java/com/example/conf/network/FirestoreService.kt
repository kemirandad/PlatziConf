package com.example.conf.network

import com.example.conf.model.Conference
import com.example.conf.model.Speaker
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

const val CONFERENCES_COLLECTION_NAME = "conferences"
const val SPEAKERS_COLLECTION_NAME = "speakers"

class FirestoreService {

    val firebaseFirestor = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestor.firestoreSettings = settings
    }

    fun getSpeakers(callback: Callback<List<Speaker>>){
        firebaseFirestor.collection(SPEAKERS_COLLECTION_NAME)
                .orderBy("category")
                .get()
                .addOnSuccessListener{
                    result ->
                    for (doc in result){
                        val list = result.toObjects(Speaker::class.java)
                        callback.onSuccess(list)
                        break
                    }
                }
    }

    fun getSchedule(callback: Callback<List<Conference>>){
        firebaseFirestor.collection(CONFERENCES_COLLECTION_NAME)
                .get()
                .addOnSuccessListener{
                    result ->
                    for (doc in result){
                        val list = result.toObjects(Conference::class.java)
                        callback.onSuccess(list)
                        break
                    }
                }
    }

}