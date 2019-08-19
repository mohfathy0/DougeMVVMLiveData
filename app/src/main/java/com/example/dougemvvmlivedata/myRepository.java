package com.example.dougemvvmlivedata;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

public class myRepository {
    private static myRepository instance;
    private static FirebaseFirestore db;
    private  static CollectionReference collectionReference;
    private static MutableLiveData<List<AnimeModel>> model;

    public static myRepository getInstance() {
        sendLog("getInstance");
        if (instance == null) {
            instance = new myRepository();
            db = FirebaseFirestore.getInstance();
            collectionReference = db.collection("anime");
            model=new MutableLiveData<>();
        }
        return instance;
    }

    public MutableLiveData<List<AnimeModel>> getData() {
        sendLog("getData");
        Query query= collectionReference.whereEqualTo("charName","Naruto sama");
        myLiveData liveData = new myLiveData(query);
       return liveData.getLiveData();
    }
    public static void sendLog(String message){
        Log.i("mylog_myRepository",message);
    }
}
