package com.example.mayn.elevatorapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mayn.elevatorapplication.Activity.mine.AboutWeActivity;
import com.example.mayn.elevatorapplication.Activity.mine.GeneralActivity;
import com.example.mayn.elevatorapplication.Activity.mine.NewInfoActivity;
import com.example.mayn.elevatorapplication.Activity.mine.PrivacyActivity;
import com.example.mayn.elevatorapplication.Activity.mine.accuntActivity;
import com.example.mayn.elevatorapplication.R;

public class MineFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView mBack4;
    private LinearLayout mUserHead;
    /**
     * 新消息通知
     */
    private TextView mUserNewmessge;
    /**
     * 隐私
     */
    private TextView mUserPrivacy;
    /**
     * 通用
     */
    private TextView mUserGeneral;
    /**
     * 关于我们
     */
    private TextView mUserAboutWe;
    /**
     * 退出登录
     */
    private TextView mUserQuit;

    public MineFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
       /* mBack4 = (TextView) view.findViewById(R.id.back4);
        mBack4.setOnClickListener(this);*/
        mUserHead = (LinearLayout) view.findViewById(R.id.User_head);
        mUserHead.setOnClickListener(this);
        mUserNewmessge = (TextView) view.findViewById(R.id.user_newmessge);
        mUserNewmessge.setOnClickListener(this);
        mUserPrivacy = (TextView) view.findViewById(R.id.user_privacy);
        mUserPrivacy.setOnClickListener(this);
        mUserGeneral = (TextView) view.findViewById(R.id.user_general);
        mUserGeneral.setOnClickListener(this);
        mUserAboutWe = (TextView) view.findViewById(R.id.user_aboutWe);
        mUserAboutWe.setOnClickListener(this);
        mUserQuit = (TextView) view.findViewById(R.id.user_quit);
        mUserQuit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
           /* case R.id.back4:
                getActivity().finish();
                break;*/
            case R.id.User_head:
                startActivity(new Intent(getActivity(),accuntActivity.class));
                break;
            case R.id.user_newmessge:
                startActivity(new Intent(getActivity(),NewInfoActivity.class));
                break;
            case R.id.user_privacy:
                startActivity(new Intent(getActivity(),PrivacyActivity.class));
                break;
            case R.id.user_general:
                startActivity(new Intent(getActivity(),GeneralActivity.class));
                break;
            case R.id.user_aboutWe:
                startActivity(new Intent(getActivity(),AboutWeActivity.class));
                break;
            case R.id.user_quit:
                getActivity().finish();
                setQuitAPP();
                break;
        }
    }

    public void setQuitAPP(){
        /*清空数据*/
        /*SharedPreferences spout =getSharedPreferences("userInfo", 0);
        SharedPreferences.Editor ed =spout.edit();
        ed.clear();
        ed.commit();*/
    }

}
