package com.example.dougemvvmlivedata;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class myRepositoryGenaric {
    /*



    ===================== This is under construction ========================



    */
    private static myRepositoryGenaric instance;
    public static myRepositoryGenaric getInstance() {
        sendLog("getInstance");
        if (instance == null) {
            instance = new myRepositoryGenaric();
        }
        return instance;
    }

    public MutableLiveData<List<AnimeModel>> getData() {
        sendLog("getData");
        CollectionReference collectionReference = FirebaseFirestore.getInstance().collection("anime");
        Query query = collectionReference.whereEqualTo("id", 1);
        myLiveDataGenaric liveData1 = new myLiveDataGenaric(query);
        ArrayList<QueryDocumentSnapshot> LiveSnap = liveData1.getLiveData().getValue();
        List<AnimeModel> models = new ArrayList<>();
        MutableLiveData<List<AnimeModel>> returnedvalue = new MutableLiveData<List<AnimeModel>>();
        if (LiveSnap != null) {
            for (QueryDocumentSnapshot snap : LiveSnap) {


                sendLog("getData loop");

                models.add(snap.toObject(AnimeModel.class));
            }

        }
        returnedvalue.setValue(models);
        return returnedvalue;
    }

    private static void sendLog(String message) {
        Log.i("mylog_myRepository", message);
    }
}
