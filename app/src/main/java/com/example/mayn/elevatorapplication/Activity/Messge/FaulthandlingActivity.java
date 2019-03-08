package com.example.mayn.elevatorapplication.Activity.Messge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.mayn.elevatorapplication.R;

public class FaulthandlingActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mMagBack5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faulthandling);
        initView();
    }

    private void initView() {
        mMagBack5 = (TextView) findViewById(R.id.mag_back5);
        mMagBack5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.mag_back5:
                FaulthandlingActivity.this.finish();
                break;
        }
    }
}
