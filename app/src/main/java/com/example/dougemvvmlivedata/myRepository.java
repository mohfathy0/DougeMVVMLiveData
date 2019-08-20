package com.example.dougemvvmlivedata;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

public class myRepository {
    private static myRepository instance;
    public static myRepository getInstance() {
        sendLog("getInstance");
        if (instance == null) {
            instance = new myRepository();
        }
        return instance;
    }

    public MutableLiveData<List<AnimeModel>> getData() {
        sendLog("getData");
        CollectionReference  collectionReference = FirebaseFirestore.getInstance().collection("anime");
        Query query = collectionReference.whereEqualTo("id", 1);
        myLiveData liveData1 = new myLiveData(query);
        return liveData1.getLiveData();
    }

    private static void sendLog(String message) {
        Log.i("mylog_myRepository", message);
    }
}
