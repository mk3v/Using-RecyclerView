package com.example.sampleapp1.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleapp1.Data.IRepository;
import com.example.sampleapp1.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    IRepository mRepository;

    public GalleryAdapter(IRepository repository) {
        mRepository = repository;
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
        holder.urlTextView.setText(url);
    }

    @Override
    public int getItemCount() {
        return mRepository.getImages().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView urlTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            urlTextView = (TextView) itemView.findViewById(R.id.text_URL);

        }
    }
}
