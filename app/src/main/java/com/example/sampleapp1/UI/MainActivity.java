package com.example.sampleapp1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.sampleapp1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment gallaryFragment = GallryFragment.newInstance();

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, gallaryFragment).commit();

    }
}
