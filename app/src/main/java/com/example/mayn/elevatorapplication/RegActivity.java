package com.example.mayn.elevatorapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 请输入账号
     */
    private EditText mUserName;
    /**
     * 请输入密码
     */
    private EditText mUserPasswd;
    /**
     * 请确认密码
     */
    private EditText mUserRepasswd;
    /**
     * 请输入邮箱
     */
    private EditText mUserEmail;
    /**
     * 获取验证码
     */
    private TextView mYanzmBtn;
    /**
     * 请输入验证码
     */
    private EditText mUserEmailnumber;
    /**
     * 我已阅读并同意服务条款
     */
    private CheckBox mUserCheckbox;
    /**
     * 注册
     */
    private TextView mUserRegbtn;
    private int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_regbtn:
                setRegDate();

                break;
            case R.id.yanzm_btn:
                num = (int) ((Math.random() * 9 + 1) * 100000);
                Toast.makeText(RegActivity.this, "验证码为"+num,
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void setRegDate(){
        String UserRegname=mUserName.getText().toString().trim();
        String UserRegPasswd=mUserPasswd.getText().toString().trim();
        String UserRegRepasswd=mUserRepasswd.getText().toString().trim();
        String UserRegEmail=mUserEmail.getText().toString().trim();
        String UserRegYZM=mUserEmailnumber.getText().toString().trim();
        String strPattern = "^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        if(TextUtils.isEmpty(UserRegname)){
            Toast.makeText(RegActivity.this, "请输入账号",
                    Toast.LENGTH_SHORT).show();
        }else
        if(TextUtils.isEmpty(UserRegPasswd)){
            Toast.makeText(RegActivity.this, "请输入密码",
                    Toast.LENGTH_SHORT).show();
        }else
        if(!UserRegRepasswd.equals(UserRegPasswd)){
            Toast.makeText(RegActivity.this, "请重新输入密码",
                    Toast.LENGTH_SHORT).show();
        }else{
            if(TextUtils.isEmpty(UserRegEmail)){
                Toast.makeText(RegActivity.this, "请输入邮箱",
                        Toast.LENGTH_SHORT).show();
            }else{
                    if(!isEmail(UserRegEmail)){
                        Toast.makeText(RegActivity.this, "邮箱格式错误",
                                Toast.LENGTH_SHORT).show();
                    }else
                        if (TextUtils.isEmpty(UserRegYZM)) {
                            Toast.makeText(RegActivity.this, "请输入验证码",
                                    Toast.LENGTH_SHORT).show();
                        } else if (!UserRegYZM.equals(num + "")) {
                            Toast.makeText(RegActivity.this, "验证码错误",
                                    Toast.LENGTH_SHORT).show();
                        } else if(!mUserCheckbox.isChecked()){
                            Toast.makeText(RegActivity.this, "是否同意服务协议",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            startActivity(new Intent(RegActivity.this, LoginActivity.class));
                            finish();
                        }

            }



        }


    }

    public static boolean isEmail(String strEmail) {
        String strPattern = "^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        if (TextUtils.isEmpty(strPattern)) {
            return false;
        } else {
            return strEmail.matches(strPattern);
        }
    }


    private void initView() {
        mUserName = (EditText) findViewById(R.id.user_name);
        mUserPasswd = (EditText) findViewById(R.id.user_passwd);
        mUserRepasswd = (EditText) findViewById(R.id.user_repasswd);
        mUserEmail = (EditText) findViewById(R.id.user_email);
        mYanzmBtn = (TextView) findViewById(R.id.yanzm_btn);
        mYanzmBtn.setOnClickListener(this);
        mUserEmailnumber = (EditText) findViewById(R.id.user_emailnumber);
        mUserCheckbox = (CheckBox) findViewById(R.id.user_checkbox);
        mUserRegbtn = (TextView) findViewById(R.id.user_regbtn);
        mUserRegbtn.setOnClickListener(this);
    }

}
