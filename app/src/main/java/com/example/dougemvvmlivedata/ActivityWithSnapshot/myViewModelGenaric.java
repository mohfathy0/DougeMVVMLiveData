package com.example.dougemvvmlivedata.ActivityWithSnapshot;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dougemvvmlivedata.AnimeModel;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.List;

public class myViewModelGenaric extends ViewModel {

    private MutableLiveData<List<QueryDocumentSnapshot>> mMainModel;
    private myRepositoryGenaric mRepository;

   public void init() {
        if (mMainModel != null) {
            return;
        }
        mRepository = myRepositoryGenaric.getInstance();
        mMainModel = mRepository.getData();
    }
    public LiveData<List<QueryDocumentSnapshot>> getHeros() {
        return mMainModel;
    }
}
