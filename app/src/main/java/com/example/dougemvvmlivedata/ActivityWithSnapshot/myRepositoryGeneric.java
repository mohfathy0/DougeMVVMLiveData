package com.example.dougemvvmlivedata.ActivityWithSnapshot;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.List;

public class myRepositoryGeneric {

    private static myRepositoryGeneric instance;
    public static myRepositoryGeneric getInstance() {
        sendLog("getInstance");
        if (instance == null) {
            instance = new myRepositoryGeneric();
        }
        return instance;
    }

    public MutableLiveData<List<QueryDocumentSnapshot>> getData() {
        sendLog("getData");
        CollectionReference collectionReference = FirebaseFirestore.getInstance().collection("anime");
        Query query = collectionReference.whereEqualTo("id", 1);
        myLiveDataGeneric liveData1 = new myLiveDataGeneric(query);
        return  liveData1.getLiveData();
    }

    private static void sendLog(String message) {
        Log.i("mylog_myRepoGeneric", message);
    }
}
