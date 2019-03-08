package com.example.mayn.elevatorapplication.Activity.Messge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.mayn.elevatorapplication.R;

public class MaintenanceActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mMagBack2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);
        initView();
    }

    private void initView() {
        mMagBack2 = (TextView) findViewById(R.id.mag_back2);
        mMagBack2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.mag_back2:
                MaintenanceActivity.this.finish();
                break;
        }
    }
}
