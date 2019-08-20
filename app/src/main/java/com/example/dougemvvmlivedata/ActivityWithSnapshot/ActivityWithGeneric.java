package com.example.dougemvvmlivedata.ActivityWithSnapshot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.dougemvvmlivedata.AnimeModel;
import com.example.dougemvvmlivedata.R;
import com.example.dougemvvmlivedata.RecAdapter;

import java.util.ArrayList;
import java.util.List;

public class ActivityWithGeneric extends AppCompatActivity implements IActivityWithGeneric {
    private RecyclerView mRecyclerView;
    private RecAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<AnimeModel> adaplist;
    IActivityWithGeneric iActivityWithGeneric = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_genaric);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        adaplist = new ArrayList<>();
        Controller ctrl = new Controller(this, iActivityWithGeneric);
        ctrl.GetDocumentWhereEquals("anime",QueryFields.myID.getField(),2);
        PrepareRecyclerView();
    }

    private void PrepareRecyclerView() {
        sendLog("PrepareRecyclerView");
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void SetAndNotifyAdapter(List<AnimeModel> modelList) {
        sendLog("SetAndNotifyAdapter");
        mAdapter.setList(modelList);
        mAdapter.notifyDataSetChanged();

    }

    public void sendLog(String message) {
        Log.i("mylog_ActivityGeneric", message);
    }
}
