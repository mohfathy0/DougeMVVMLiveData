package com.example.dougemvvmlivedata.ActivityWithSnapshotWithBinding.ActivityWithSnapshot;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.List;

public class myRepositoryGenericB {

    private static myRepositoryGenericB instance;
    public static myRepositoryGenericB getInstance() {
        sendLog("getInstance");
        if (instance == null) {
            instance = new myRepositoryGenericB();
        }
        return instance;
    }

    public MutableLiveData<List<QueryDocumentSnapshot>> getData(String collectionPath,String fieldName,int value) {
        sendLog("getData");
        CollectionReference collectionReference = FirebaseFirestore.getInstance().collection(collectionPath);
        Query query = collectionReference.whereEqualTo(fieldName, value);
        myLiveDataGenericB liveData1 = new myLiveDataGenericB(query);
        return  liveData1.getLiveData();
    }
    public MutableLiveData<List<QueryDocumentSnapshot>> getData(String collectionPath,String fieldName,String value) {
        sendLog("getData");
        CollectionReference collectionReference = FirebaseFirestore.getInstance().collection(collectionPath);
        Query query = collectionReference.whereEqualTo(fieldName, value);
        myLiveDataGenericB liveData1 = new myLiveDataGenericB(query);
        return  liveData1.getLiveData();
    }

    private static void sendLog(String message) {
        Log.i("mylog_myRepoGenericB", message);
    }
}
