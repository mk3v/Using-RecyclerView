package com.example.sampleapp1.UI;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.sampleapp1.Data.Image;
import com.example.sampleapp1.Data.Repository;

import java.util.List;

public class GalleryFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<List<Image>> mImagesLiveList;

    public GalleryFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Image>> getImagesLiveList(){

        if (mImagesLiveList == null) {
            mImagesLiveList = new MutableLiveData<>();
            loadImages();
        }

        return mImagesLiveList;
    }

    private void loadImages() {

        mImagesLiveList = Repository.createImageList(getApplication().getApplicationContext());

    }

}
