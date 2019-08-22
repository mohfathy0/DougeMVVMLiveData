package com.example.dougemvvmlivedata.ActivityWithSnapshotWithBinding.ActivityWithSnapshot;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dougemvvmlivedata.AnimeModel;
import com.example.dougemvvmlivedata.R;
import com.example.dougemvvmlivedata.databinding.ActivityWithGenaricWithBBinding;
import java.util.ArrayList;
import java.util.List;

public class ActivityWithGenericBB extends AppCompatActivity implements IActivityWithGenericB {
    private RecyclerView mRecyclerView;
    private RecAdapterB mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<AnimeModel> adaplist;
    IActivityWithGenericB iActivityWithGenericB = this;
    private ControllerB ctrl;
    private ActivityWithGenaricWithBBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_with_genaric_with_b);
        mainBinding.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ctrl = new ControllerB(this, iActivityWithGenericB);
        ctrl.GetDocumentWhereEquals(QueryCollection.NAME, QueryFields.ID, 2);
        PrepareRecycler();
        sendLog("nCreate");
    }

    private void PrepareRecycler() {
        adaplist = new ArrayList<>();
        mAdapter = new RecAdapterB(this);
        mainBinding.mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void SetAndNotifyAdapter(List<AnimeModel> modelList) {
        sendLog("SetAndNotifyAdapter");
        mAdapter.setList(modelList);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ctrl.onDestroy();
    }

    public void sendLog(String message) {
        Log.i("mylog_ActivityGenericB", message);
    }
}
