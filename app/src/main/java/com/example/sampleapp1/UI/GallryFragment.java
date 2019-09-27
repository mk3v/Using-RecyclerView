package com.example.sampleapp1.UI;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sampleapp1.Data.Repository;
import com.example.sampleapp1.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GallryFragment extends Fragment {

    View mRootView = null;
    RecyclerView mGalleryRecyclerView = null;

    public static GallryFragment newInstance() {

        Bundle args = new Bundle();

        GallryFragment fragment = new GallryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public GallryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_gallary, container, false);
        initializeRecyclerView();
        return mRootView;
    }

    private void initializeRecyclerView() {
        mGalleryRecyclerView = mRootView.findViewById(R.id.galleryRecyclerView);
        GalleryAdapter galleryAdapter = new GalleryAdapter(new Repository(), getContext());
        mGalleryRecyclerView.setAdapter(galleryAdapter);
     //   mGalleryRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
mGalleryRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

    }


}
