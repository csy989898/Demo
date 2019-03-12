package com.example.mayn.elevatorapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RecoverPasswdActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mPasswdRecoverEmail;
    private TextView mUserTijiaobtn;
    private TextView mBack3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_passwd);
        mPasswdRecoverEmail = findViewById(R.id.passwd_recover_email);
        mUserTijiaobtn = findViewById(R.id.user_tijiaobtn);
        mUserTijiaobtn.setOnClickListener(this);
        mBack3 = findViewById(R.id.back3);
        mBack3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_tijiaobtn:
                String mPasswdRecoverEmails=mPasswdRecoverEmail.getText().toString().trim();
                RegActivity reg=new RegActivity();
                if(TextUtils.isEmpty(mPasswdRecoverEmails)){
                    Toast.makeText(RecoverPasswdActivity.this,"请输入你的邮箱",Toast.LENGTH_LONG).show();
                }else {
                    if(reg.isEmail(mPasswdRecoverEmails)){
                        startActivity(new Intent(RecoverPasswdActivity.this,LoginActivity.class));
                        RecoverPasswdActivity.this.finish();
                    }else{
                        Toast.makeText(RecoverPasswdActivity.this,"邮箱格式错误",Toast.LENGTH_LONG).show();
                    }
            }
                break;
            case R.id.back3:
                RecoverPasswdActivity.this.finish();
                break;
        }
    }


}
