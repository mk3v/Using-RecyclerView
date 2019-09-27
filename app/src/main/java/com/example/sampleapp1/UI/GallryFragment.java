package com.example.sampleapp1.UI;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sampleapp1.Data.Image;
import com.example.sampleapp1.Data.Repository;
import com.example.sampleapp1.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GallryFragment extends Fragment {

    View mRootView = null;
    RecyclerView mGalleryRecyclerView = null;
    Repository mRepository = null;
    GalleryFragmentViewModel viewModel = null;


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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       viewModel = ViewModelProviders.of(this).get(GalleryFragmentViewModel.class);
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
        GalleryAdapter adapter = new GalleryAdapter(getContext(), Repository.createImageList(getContext()).getValue());
        mGalleryRecyclerView.setAdapter(adapter);

       viewModel.getImagesLiveList().observe(this, new Observer<List<Image>>() {
           @Override
           public void onChanged(List<Image> images) {

               ((GalleryAdapter) mGalleryRecyclerView.getAdapter()).updageImages(images);
               mGalleryRecyclerView.getAdapter().notifyDataSetChanged();
           }
       });


     //   mGalleryRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mGalleryRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

    }


}
