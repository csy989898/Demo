package com.example.mayn.elevatorapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mayn.elevatorapplication.Activity.Messge.EmergencyrescueActivity;
import com.example.mayn.elevatorapplication.Activity.Messge.FaulthandlingActivity;
import com.example.mayn.elevatorapplication.Activity.Messge.InfoActivity;
import com.example.mayn.elevatorapplication.Activity.Messge.MaintenanceActivity;
import com.example.mayn.elevatorapplication.Activity.Messge.RemindActivity;
import com.example.mayn.elevatorapplication.Activity.NewInfoActivity;
import com.example.mayn.elevatorapplication.R;

public class MessgeFragment extends Fragment implements View.OnClickListener {

    private View view;
    /**
     * 通知
     */
    private TextView mMsg1;
    /**
     * 维保逾期
     */
    private TextView mMsg2;
    /**
     * 维保提醒
     */
    private TextView mMsg3;
    /**
     * 应急救援
     */
    private TextView mMsg4;
    /**
     * 故障处理
     */
    private TextView mMsg5;
    /**
     * 推荐路线
     */
    private TextView mMsg6;

    public MessgeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messge, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mMsg1 = (TextView) view.findViewById(R.id.msg1);
        mMsg1.setOnClickListener(this);
        mMsg2 = (TextView) view.findViewById(R.id.msg2);
        mMsg2.setOnClickListener(this);
        mMsg3 = (TextView) view.findViewById(R.id.msg3);
        mMsg3.setOnClickListener(this);
        mMsg4 = (TextView) view.findViewById(R.id.msg4);
        mMsg4.setOnClickListener(this);
        mMsg5 = (TextView) view.findViewById(R.id.msg5);
        mMsg5.setOnClickListener(this);
        mMsg6 = (TextView) view.findViewById(R.id.msg6);
        mMsg6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.msg1:
                /*信息*/
                startActivity(new Intent(getActivity(), InfoActivity.class));
                break;
            case R.id.msg2:
                /*维保逾期*/
                startActivity(new Intent(getActivity(), MaintenanceActivity.class));
                break;
            case R.id.msg3:
                /*维保提醒*/
                startActivity(new Intent(getActivity(), RemindActivity.class));
                break;
            case R.id.msg4:
                /*应急救援*/
                startActivity(new Intent(getActivity(), EmergencyrescueActivity.class));
                break;
            case R.id.msg5:
                /*故障处理*/
                startActivity(new Intent(getActivity(), FaulthandlingActivity.class));
                break;
            case R.id.msg6:
                startActivity(new Intent(getActivity(), MaintenanceActivity.class));
                break;
        }
    }
}
