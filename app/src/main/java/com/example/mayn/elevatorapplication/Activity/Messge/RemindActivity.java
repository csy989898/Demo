package com.example.mayn.elevatorapplication.Activity.Messge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.mayn.elevatorapplication.R;

public class RemindActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mMagBack3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind);
        initView();
    }

    private void initView() {
        mMagBack3 = (TextView) findViewById(R.id.mag_back3);
        mMagBack3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.mag_back3:
                RemindActivity.this.finish();
                break;
        }
    }
}
