package com.example.mayn.elevatorapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayn.elevatorapplication.R;
import com.example.mayn.elevatorapplication.View.WiperSwitch;

/*
 * 通用
 * */
public class GeneralActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mMsgBack4;
    private LinearLayout mLanguge;
    private WiperSwitch mWiperSwitc;
    private LinearLayout mGongneng;
    private LinearLayout mShiming;
    private LinearLayout mShouquan;
    private boolean SQM_NUM=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        initView();
    }

    private void initView() {
        mMsgBack4 = (TextView) findViewById(R.id.msg_back4);
        mMsgBack4.setOnClickListener(this);
        mLanguge = (LinearLayout) findViewById(R.id.languge);
        mLanguge.setOnClickListener(this);
        mWiperSwitc = (WiperSwitch) findViewById(R.id.wiperSwitc);
        mWiperSwitc.setOnClickListener(this);
        mGongneng = (LinearLayout) findViewById(R.id.gongneng);
        mGongneng.setOnClickListener(this);
        mShiming = (LinearLayout) findViewById(R.id.shiming);
        mShiming.setOnClickListener(this);
        mShouquan = (LinearLayout) findViewById(R.id.shouquan);
        mShouquan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.msg_back4:
                GeneralActivity.this.finish();
                break;
            case R.id.languge:
                Toast.makeText(GeneralActivity.this,"多语言",Toast.LENGTH_SHORT).show();
                break;
            case R.id.wiperSwitc:
                break;
            case R.id.gongneng:
                Toast.makeText(GeneralActivity.this,"功能",Toast.LENGTH_SHORT).show();
                break;
            case R.id.shiming:
                Toast.makeText(GeneralActivity.this,"实名认证",Toast.LENGTH_SHORT).show();
                /*跳转*/
                setAccountDate();
                break;
            case R.id.shouquan:
                Toast.makeText(GeneralActivity.this,"授权设备",Toast.LENGTH_SHORT).show();
                /*弹框*/
                break;
        }
    }

    public void setAccountDate(){




    }

}
