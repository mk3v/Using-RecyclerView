package com.example.sampleapp1.Data.JsonModel;

import com.google.gson.annotations.SerializedName;

public class ImagesPhotos {


    @SerializedName("photo")
    public ImageSinge[] photo;


    public ImageSinge[] getPhoto() {
        return photo;
    }

    public void setPhoto(ImageSinge[] photo) {
        this.photo = photo;
    }
}
