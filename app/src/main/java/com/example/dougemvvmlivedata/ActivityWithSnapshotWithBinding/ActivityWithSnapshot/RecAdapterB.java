package com.example.dougemvvmlivedata.ActivityWithSnapshotWithBinding.ActivityWithSnapshot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dougemvvmlivedata.AnimeModel;
import com.example.dougemvvmlivedata.R;
import com.example.dougemvvmlivedata.databinding.RecyclerviewLayoutWithBBinding;

import java.util.ArrayList;
import java.util.List;


public class RecAdapterB extends RecyclerView.Adapter<RecAdapterB.myViewHolder> {
    private List<AnimeModel> animeModels;
    private Context mContext;

    public RecAdapterB(Context mContext) {

        this.mContext = mContext;
        this.animeModels= new ArrayList<>();
    }


     static class myViewHolder extends RecyclerView.ViewHolder {
        /*
         ImageView mImageView;
         TextView mTextviewName;
         TextView mTextviewTitle;
         */
        RecyclerviewLayoutWithBBinding recyclerviewLayoutwithbBinding;

         myViewHolder(@NonNull RecyclerviewLayoutWithBBinding  itemView) {
            super(itemView.getRoot());
            recyclerviewLayoutwithbBinding=itemView;
            /*
            mImageView = itemView.findViewById(R.id.imageView);
            mTextviewName = itemView.findViewById(R.id.textViewName);
            mTextviewTitle = itemView.findViewById(R.id.textViewTitle);
            */
        }
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerviewLayoutWithBBinding recyclerviewLayoutwithbBinding= DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),R.layout.recyclerview_layout_with_b,parent,false);

        /*
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout, parent, false);
        return new myViewHolder(view);
        */
        myViewHolder myViewHolder= new myViewHolder(recyclerviewLayoutwithbBinding);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        AnimeModel currentItem = animeModels.get(position);
        holder.recyclerviewLayoutwithbBinding.setModel(currentItem);
        /*
        holder.mTextviewName.setText(currentItem.getCharName());
        holder.mTextviewTitle.setText(currentItem.getCharTitle());
        Glide.with(mContext).asBitmap().load(currentItem.getImageURL()).dontAnimate().into(holder.mImageView);
        */
    }

    // دي الميثود الزياده
   public void setList(List<AnimeModel> models) {
        this.animeModels = models;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return animeModels.size();
    }
}
