package com.example.dougemvvmlivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.example.dougemvvmlivedata.ActivityWithSnapshotWithBinding.ActivityWithSnapshot.ActivityWithGenericBB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private myViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private RecAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<AnimeModel> adaplist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        adaplist = new ArrayList<>();

        mViewModel = ViewModelProviders.of(this).get(myViewModel.class);
        mViewModel.init();
        mViewModel.getHeros().observe(this, new Observer<List<AnimeModel>>() {

            @Override
            public void onChanged(List<AnimeModel> animeModels) {

                if (animeModels.size() > 0) {
                    sendLog("onChanged > 0");
                    // زي ما قولت تحت هنا هحط الداتا في الادابتر في كل مره تتعدل
                    mAdapter.setList(animeModels);
                    mAdapter.notifyDataSetChanged();

                } else {
                    sendLog("onChanged = 0");
                }
            }

        });
        PrepareRecyclerView();
    }

    private void PrepareRecyclerView() {
        sendLog("PrepareRecyclerView");
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void sendLog(String message) {
        Log.i("mylog_MainActivity", message);
    }


    public void buttonGeneric_Click(View view){
        Intent i = new Intent(this, ActivityWithGenericBB.class);
        startActivity(i);
    }
}
