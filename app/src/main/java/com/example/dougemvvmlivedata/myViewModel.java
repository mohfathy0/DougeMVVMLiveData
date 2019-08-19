package com.example.dougemvvmlivedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

class myViewModel extends ViewModel {

    private MutableLiveData<List<AnimeModel>> mMainModel;
    private myRepository mRepository;

    void init() {
        if (mMainModel != null) {
            return;
        }
        mRepository = myRepository.getInstance();
        mMainModel = mRepository.getData();
    }
    LiveData<List<AnimeModel>> getHeros() {
        return mMainModel;
    }
}
