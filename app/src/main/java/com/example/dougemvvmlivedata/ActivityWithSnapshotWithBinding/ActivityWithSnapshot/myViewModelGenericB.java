package com.example.dougemvvmlivedata.ActivityWithSnapshotWithBinding.ActivityWithSnapshot;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.List;

public class myViewModelGenericB extends ViewModel {

    private MutableLiveData<List<QueryDocumentSnapshot>> mMainModel;
    private myRepositoryGenericB mRepository;

    public void init() {
        if (mMainModel != null) {
            return;
        }
        mRepository = myRepositoryGenericB.getInstance();

        }



    public void RequestDataFromRepo(String collectionPath,String fieldName,int value){
        mMainModel = mRepository.getData(collectionPath,fieldName,value);
    }
    public void RequestDataFromRepo(String collectionPath,String fieldName,String value){
        mMainModel = mRepository.getData(collectionPath,fieldName,value);
    }

    public LiveData<List<QueryDocumentSnapshot>> getHeros() {
        return mMainModel;
    }
}
