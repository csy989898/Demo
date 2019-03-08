package com.example.mayn.elevatorapplication.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mayn.elevatorapplication.R;

public class CleancircleFragment extends android.support.v4.app.Fragment {

    public CleancircleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_fragment, container, false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        txt_content.setText("第4个Fragment");
        Log.e("HEHE", "第一个Fragment");
        return view;
    }
}
