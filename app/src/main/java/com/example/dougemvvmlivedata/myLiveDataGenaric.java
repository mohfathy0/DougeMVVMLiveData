package com.example.dougemvvmlivedata;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import javax.annotation.Nullable;
    /*



    ===================== This is under construction ========================



    */
    //https://www.youtube.com/watch?v=WXc4adLMDqk&feature=share&fbclid=IwAR1_nYdrUDP9cm4dD_qT4LUshpl22cb4-HZeb2OrSGbBJ-dYWILcwCcBARQ
    //https://github.com/Bassem-Kamal/TryUsingMVVMWithFireBase/blob/master/ItemRepository.java
    //https://stackoverflow.com/questions/49798814/android-architecture-components-with-firebase-specifically-firestore


public class myLiveDataGenaric extends LiveData<DocumentReference> implements EventListener<QuerySnapshot> {
    private Query query;
    private ListenerRegistration listener;
    private MutableLiveData<ArrayList<QueryDocumentSnapshot>> mListOfDocument;


    public myLiveDataGenaric(Query query) {
        sendLog("Constructor");
        listener = query.addSnapshotListener(this);
        this.query = query;
        mListOfDocument = new MutableLiveData<ArrayList<QueryDocumentSnapshot>>();

    }

    @Override
    protected void onActive() {
        super.onActive();
        sendLog("onActive");
        listener = query.addSnapshotListener(this);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        sendLog("onInactive");
        listener.remove();
        listener = null;
    }


    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

//        if (queryDocumentSnapshots != null && e == null) {
//
////            ArrayList<QueryDocumentSnapshot> models = new ArrayList<>();
////            for (QueryDocumentSnapshot snap : queryDocumentSnapshots) {
////                sendLog("onEvent");
////
////                models.add(snap);
////            }
//            QuerySnapshot snapshots = queryDocumentSnapshots;
//            mListOfDocument.setValue(snapshots);
//
//        } else {
//            // handle errors
//            sendLog("onEvent Error");
//        }
        if (queryDocumentSnapshots != null && e == null) {

            ArrayList<QueryDocumentSnapshot> models = new ArrayList<>();
            for (QueryDocumentSnapshot snap : queryDocumentSnapshots) {
                sendLog("onEvent");

                models.add(snap);
            }
            mListOfDocument.setValue(models);

        } else {
            // handle errors
            sendLog("onEvent Error");
        }
    }

    public MutableLiveData<ArrayList<QueryDocumentSnapshot>> getLiveData() {
        sendLog("getLiveData");
        return mListOfDocument;
    }

    private void sendLog(String message) {
        Log.i("mylog_myLiveData", message);
    }


}
