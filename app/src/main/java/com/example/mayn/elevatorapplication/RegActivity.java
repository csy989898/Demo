package com.example.mayn.elevatorapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView user_regbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        user_regbtn=findViewById(R.id.user_regbtn);
        user_regbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_regbtn:
                startActivity(new Intent(RegActivity.this,LoginActivity.class));
                finish();
                break;

        }
    }
}
