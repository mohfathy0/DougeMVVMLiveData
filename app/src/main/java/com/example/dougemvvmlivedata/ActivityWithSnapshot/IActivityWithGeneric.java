package com.example.dougemvvmlivedata.ActivityWithSnapshot;

import com.example.dougemvvmlivedata.AnimeModel;

import java.util.List;

interface IActivityWithGeneric {
    void SetAndNotifyAdapter(List<AnimeModel> modelList);
}
