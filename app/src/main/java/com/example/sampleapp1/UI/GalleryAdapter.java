package com.example.sampleapp1.UI;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.sampleapp1.Data.IRepository;
import com.example.sampleapp1.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    IRepository mRepository;
    Context mContext;

    public GalleryAdapter(IRepository repository, Context context) {
        mRepository = repository;
        mContext = context;
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
        String url =  mRepository.getImages().get(position).url;
        Glide.with(mContext).load(url).placeholder(R.mipmap.ic_placeholder_image).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mRepository.getImages().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
