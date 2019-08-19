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
import java.util.List;

import javax.annotation.Nullable;

public class myLiveData extends LiveData<DocumentReference> implements EventListener<QuerySnapshot> {
    private Query query;
    private ListenerRegistration listener;
    private MutableLiveData<List<AnimeModel>> mListOfDocument;


    myLiveData(Query query) {
        sendLog("Constructor");
        listener = query.addSnapshotListener(this);
        this.query = query;
        mListOfDocument = new MutableLiveData<>();

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

        if (queryDocumentSnapshots != null && e == null) {

            ArrayList<AnimeModel> models = new ArrayList<>();
            for (QueryDocumentSnapshot snap : queryDocumentSnapshots) {
                sendLog("onEvent");

                models.add(snap.toObject(AnimeModel.class));
            }
            mListOfDocument.setValue(models);

        } else {
            // handle errors
            sendLog("onEvent Error");
        }
    }

    MutableLiveData<List<AnimeModel>> getLiveData() {
        sendLog("getLiveData");
        return mListOfDocument;
    }

    private void sendLog(String message) {
        Log.i("mylog_myLiveData", message);
    }


}
