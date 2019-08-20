package com.example.dougemvvmlivedata.ActivityWithSnapshot;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
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

    public void GetDocumentWhereEquals(String collectionPath, String fieldName, int value) {
        mViewModel.init();
        mViewModel.RequestDataFromRepo(collectionPath,fieldName,value);
        sendLog("Control");
        mViewModel.getHeros().observe(activity, new Observer<List<QueryDocumentSnapshot>>() {
            @Override
            public void onChanged(List<QueryDocumentSnapshot> queryDocumentSnapshots) {
                sendLog("onChanged");
                ArrayList<AnimeModel>list=new ArrayList<>();
                for (QueryDocumentSnapshot snap : queryDocumentSnapshots) {
                    list.add(snap.toObject(AnimeModel.class));
                }
                igeneric.SetAndNotifyAdapter(list);
            }
        });

    }
    public void GetDocumentWhereEquals(String collectionPath, String fieldName, String value) {
        mViewModel.init();
        mViewModel.RequestDataFromRepo(collectionPath,fieldName,value);
        sendLog("Control");
        mViewModel.getHeros().observe(activity, new Observer<List<QueryDocumentSnapshot>>() {
            @Override
            public void onChanged(List<QueryDocumentSnapshot> queryDocumentSnapshots) {
                sendLog("onChanged");
                ArrayList<AnimeModel>list=new ArrayList<>();
                for (QueryDocumentSnapshot snap : queryDocumentSnapshots) {
                    list.add(snap.toObject(AnimeModel.class));
                }
                igeneric.SetAndNotifyAdapter(list);
            }
        });

    }


    public void sendLog(String message) {
        Log.i("mylog_Controller", message);
    }


}
