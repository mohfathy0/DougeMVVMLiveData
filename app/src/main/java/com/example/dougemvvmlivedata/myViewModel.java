package com.example.dougemvvmlivedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class myViewModel extends ViewModel {

    private MutableLiveData<List<AnimeModel>> mMainModel;
    private myRepository mRepository;

   public void init() {
        if (mMainModel != null) {
            return;
        }
        mRepository = myRepository.getInstance();
        mMainModel = mRepository.getData();
    }
    public LiveData<List<AnimeModel>> getHeros() {
        return mMainModel;
    }
}
