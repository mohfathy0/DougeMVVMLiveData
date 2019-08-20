package com.example.dougemvvmlivedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class RecAdapter extends RecyclerView.Adapter<RecAdapter.myViewHolder> {
    private List<AnimeModel> animeModels;
    private Context mContext;

    public RecAdapter(Context mContext) {

        this.mContext = mContext;
        this.animeModels= new ArrayList<>();
    }


     static class myViewHolder extends RecyclerView.ViewHolder {

         ImageView mImageView;
         TextView mTextviewName;
         TextView mTextviewTitle;


         myViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextviewName = itemView.findViewById(R.id.textViewName);
            mTextviewTitle = itemView.findViewById(R.id.textViewTitle);
        }
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        AnimeModel currentItem = animeModels.get(position);
        holder.mTextviewName.setText(currentItem.getCharName());
        holder.mTextviewTitle.setText(currentItem.getCharTitle());
        Glide.with(mContext).asBitmap().load(currentItem.getImageURL()).dontAnimate().into(holder.mImageView);
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
