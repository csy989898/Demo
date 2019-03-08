package com.example.mayn.elevatorapplication.Activity.Messge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.mayn.elevatorapplication.R;

public class EmergencyrescueActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mMagBack4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencyrescue);
        initView();
    }

    private void initView() {
        mMagBack4 = (TextView) findViewById(R.id.mag_back4);
        mMagBack4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.mag_back4:
                EmergencyrescueActivity.this.finish();
                break;
        }
    }
}
