package com.example.mayn.elevatorapplication.Fragment.fragment_home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mayn.elevatorapplication.R;

public class Fragment_tuijian extends Fragment {
        private  View view;
        private Context mcontext;

    public Fragment_tuijian() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.fragment_tuijian,null);
        return view;
    }
}
