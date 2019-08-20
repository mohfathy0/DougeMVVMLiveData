package com.example.dougemvvmlivedata.ActivityWithSnapshot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.dougemvvmlivedata.AnimeModel;
import com.example.dougemvvmlivedata.R;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class ActivityWithGeneric extends AppCompatActivity {
    private myViewModelGeneric mViewModel;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<AnimeModel> adaplist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_genaric);
        adaplist = new ArrayList<>();

        mViewModel = ViewModelProviders.of(this).get(myViewModelGeneric.class);
        mViewModel.init();
        mViewModel.getHeros().observe(this, new Observer<List<QueryDocumentSnapshot>>() {
            @Override
            public void onChanged(List<QueryDocumentSnapshot> queryDocumentSnapshots) {
                for (QueryDocumentSnapshot snap:queryDocumentSnapshots) {
                    sendLog(snap.toObject(AnimeModel.class).getCharName());
                    sendLog(snap.toObject(AnimeModel.class).getCharTitle());
                    sendLog(snap.toObject(AnimeModel.class).getImageURL());
                }
            }
        });
    }


    public void sendLog(String message) {
        Log.i("mylog_ActivityGeneric", message);
    }
}
