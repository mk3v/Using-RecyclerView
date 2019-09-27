package com.example.sampleapp1.Data;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository{


    @Override
    public List<Image> getImages() {
        List<Image> imageList = new ArrayList<>();
        imageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        imageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        imageList.add(new Image("https://upload.wikimedia.org/wikipedia/commons/7/74/Earth_poster_large.jpg"));
        imageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        imageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        imageList.add(new Image("https://upload.wikimedia.org/wikipedia/commons/7/74/Earth_poster_large.jpg"));
        imageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        imageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        imageList.add(new Image("https://upload.wikimedia.org/wikipedia/commons/7/74/Earth_poster_large.jpg"));
        imageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        imageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        imageList.add(new Image("https://upload.wikimedia.org/wikipedia/commons/7/74/Earth_poster_large.jpg"));
        imageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        imageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        imageList.add(new Image("https://upload.wikimedia.org/wikipedia/commons/7/74/Earth_poster_large.jpg"));
        imageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        imageList.add(new Image("https://image.shutterstock.com/image-photo/peaceful-autumn-scene-vorderer-gosausee-600w-746944825.jpg"));
        imageList.add(new Image("https://upload.wikimedia.org/wikipedia/commons/7/74/Earth_poster_large.jpg"));

        return imageList;
    }
}
