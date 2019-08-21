package com.example.dougemvvmlivedata.ActivityWithSnapshotWithBinding.ActivityWithSnapshot;


import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dougemvvmlivedata.AnimeModel;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private AppCompatActivity activity;
    private static myViewModelGeneric mViewModel;
    private IActivityWithGeneric igeneric;



    public Controller(AppCompatActivity parent, IActivityWithGeneric activityWithGeneric) {
        activity = parent;
        igeneric = activityWithGeneric;

        if (mViewModel == null) {
            mViewModel = ViewModelProviders.of(parent).get(myViewModelGeneric.class);

        }
        sendLog("constractor");
    }


    // Firebase queries
    public void GetDocumentWhereEquals(String collectionPath, String fieldName, int value) {

        mViewModel.init();
        mViewModel.RequestDataFromRepo(collectionPath, fieldName, value);
        sendLog("Control");
        mViewModel.getHeros().observe(activity, new Observer<List<QueryDocumentSnapshot>>() {
            @Override
            public void onChanged(List<QueryDocumentSnapshot> queryDocumentSnapshots) {
                sendLog("onChanged");
                ArrayList<AnimeModel> list = new ArrayList<>();
                for (QueryDocumentSnapshot snap : queryDocumentSnapshots) {
                    list.add(snap.toObject(AnimeModel.class));
                }
                igeneric.SetAndNotifyAdapter(list);
            }
        });

    }

    public void GetDocumentWhereEquals(String collectionPath, String fieldName, String value) {
        mViewModel.init();
        mViewModel.RequestDataFromRepo(collectionPath, fieldName, value);
        sendLog("Control");
        mViewModel.getHeros().observe(activity, new Observer<List<QueryDocumentSnapshot>>() {
            @Override
            public void onChanged(List<QueryDocumentSnapshot> queryDocumentSnapshots) {
                sendLog("onChanged");
                ArrayList<AnimeModel> list = new ArrayList<>();
                for (QueryDocumentSnapshot snap : queryDocumentSnapshots) {
                    list.add(snap.toObject(AnimeModel.class));
                }
                igeneric.SetAndNotifyAdapter(list);
            }
        });

    }

    public void onDestroy(){
        activity=null;
        igeneric=null;
        mViewModel=null;
    }


    public void sendLog(String message) {
        Log.i("mylog_Controller", message);
    }


}
