package com.example.dougemvvmlivedata.ActivityWithSnapshotWithBinding.ActivityWithSnapshot;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class AnimeModelB {
    private String imageURL;
    private String charName;
    private String charTitle;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AnimeModelB() {
    }

    public AnimeModelB(String imageURL, String charName, String charTitle, int id) {
        this.imageURL = imageURL;
        this.charName = charName;
        this.charTitle = charTitle;
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getCharTitle() {
        return charTitle;
    }

    public void setCharTitle(String charTitle) {
        this.charTitle = charTitle;
    }

    @BindingAdapter("ImageURL")
    public static void loadImage(View view , String imageURL){
        ImageView imageView = (ImageView) view;
        Glide.with(imageView.getContext()).asBitmap().load(imageURL).dontAnimate().into(imageView);

    }
}
