package com.example.sampleapp1.Data;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository{


    @Override
    public List<Image> getImages() {
        List<Image> imageList = new ArrayList<>();
        imageList.add(new Image("url1"));
        imageList.add(new Image("url2"));
        imageList.add(new Image("url3"));

        return imageList;
    }
}
