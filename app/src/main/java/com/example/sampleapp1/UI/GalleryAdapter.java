package com.example.sampleapp1.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sampleapp1.Data.IRepository;
import com.example.sampleapp1.Data.Image;
import com.example.sampleapp1.R;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {


    Context mContext;
    List<Image> mImageList;

    public GalleryAdapter(Context context, List<Image> imageList) {

        mImageList = imageList;
        mContext = context;
    }

    public void updageImages(List<Image> images) {
        mImageList = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View galleryItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_recyclerview_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(galleryItemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       String url = mImageList.get(position).url;
        Glide.with(mContext).load(url).placeholder(R.mipmap.ic_placeholder_image).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(mImageList == null)
            return 0;
        return mImageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
