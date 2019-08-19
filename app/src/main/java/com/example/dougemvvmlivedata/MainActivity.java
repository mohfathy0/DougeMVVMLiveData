package com.example.dougemvvmlivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


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
        adaplist= new ArrayList<>();

        mViewModel = ViewModelProviders.of(this).get(myViewModel.class);
        mViewModel.init();
        mViewModel.getHeros().observe(this, new Observer<List<AnimeModel>>() {

            @Override
            public void onChanged(List<AnimeModel> animeModels) {

                if (animeModels.size()>0) {
                    sendLog("onChanged > 0");
                    sendLog(animeModels.get(0).getCharName());
                    for (AnimeModel model:animeModels){
                        // هنا لازم اشوف طريقة تانيه عشان كده انا سايب الداتا علي الاكتيفيتي و ده المفروض مش صح
                        // لسه عايز افكر اغير الموضوع ده ازاي
                        adaplist.clear();
                        adaplist.add(model);
                    }


                   mAdapter.notifyDataSetChanged();

                }else {
                    sendLog("onChanged = 0");
                }
            }

        });
        PrepareRecyclerView();
    }

    private void PrepareRecyclerView() {
        sendLog("PrepareRecyclerView");
        // المشكله هنا لما بجيب الداتا علي طول من الفيو موديل بتتاخر فبيكون الحجم بتاع الادابتر zero او null
       // mAdapter = new RecAdapter(this,mViewModel.getHeros().getValue());
        mAdapter = new RecAdapter(this,adaplist);
            mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void sendLog(String message) {
        Log.i("mylog_myLiveData", message);
    }
}
