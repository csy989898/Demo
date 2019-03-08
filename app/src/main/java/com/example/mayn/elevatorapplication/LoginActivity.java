package com.example.mayn.elevatorapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText login_name,login_passwd;
    private CheckBox login_auto,login_rember;
    private TextView login_loginbtn,login_reg_btn,login_customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_loginbtn=findViewById(R.id.login_loginbtn);
        login_loginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_loginbtn:
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
                break;

        }
    }
}
