package com.example.mayn.elevatorapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mayn.elevatorapplication.Activity.mine.NewInfo_msgActivity;
import com.example.mayn.elevatorapplication.R;
/*
* 新消息通知
* */
public class NewInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mInfoBack1;
    private LinearLayout mNewinfoMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_info);
        initView();
    }

    private void initView() {
        mInfoBack1 = (TextView) findViewById(R.id.info_back1);
        mInfoBack1.setOnClickListener(this);
        mNewinfoMsg = (LinearLayout) findViewById(R.id.newinfo_msg);
        mNewinfoMsg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.info_back1:
                NewInfoActivity.this.finish();
                break;
            case R.id.newinfo_msg:
                startActivity(new Intent(NewInfoActivity.this,NewInfo_msgActivity.class));
                break;
        }
    }
}
