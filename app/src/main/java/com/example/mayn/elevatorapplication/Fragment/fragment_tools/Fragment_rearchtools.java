package com.example.mayn.elevatorapplication.Fragment.fragment_tools;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mayn.elevatorapplication.R;

import java.util.Random;

public class Fragment_rearchtools extends Fragment implements View.OnClickListener {
    private View view;
    public Context mcontext;
    /**
     * 默纳克
     */
    private TextView mToolsName;
    /**
     * MCTC-MCB-G2
     */
    private TextView mToolsSize;
    private Spinner mSpinnerTools;
    /**
     * 查询
     */
    private Button mRearchBtn;
    /**  */
    private TextView mTextContent;
    /**  */
    private TextView mTextContent2;

    public Fragment_rearchtools() {
    }
    private String[] str1={"e1","e2","e3","e4","e5","e6","e7","e8","e9","e10"};
    private String[] str2={"eeeeeeeee1","eeeeeee2","eeeeeeeeee3","eeeeeeeeee4",
            "eeeeeeee5","eeeeeeee6","eeeeeeeeee7","eeeeeeeeee8","eeeeeeeee9","eeeeeeeee10"};

    private int num=1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rearchtools, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mToolsName = (TextView) view.findViewById(R.id.tools_name);
        mToolsName.setOnClickListener(this);
        mToolsSize = (TextView) view.findViewById(R.id.tools_size);
        mToolsSize.setOnClickListener(this);
        mSpinnerTools = (Spinner) view.findViewById(R.id.spinner_tools);
        mRearchBtn = (Button) view.findViewById(R.id.rearch_btn);
        mRearchBtn.setOnClickListener(this);
        mTextContent = (TextView) view.findViewById(R.id.text_content);
        mTextContent.setOnClickListener(this);
        mTextContent2 = (TextView) view.findViewById(R.id.text_content2);
        mTextContent2.setOnClickListener(this);
        mSpinnerTools.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        num=1;
                        break;
                    case 1:
                        num=2;
                        break;
                    case 2:
                        num=3;
                        break;
                    case 3:
                        num=4;
                        break;
                    case 4:
                        num=5;
                        break;
                    case 5:
                        num=6;
                        break;
                    case 6:
                        num=7;
                        break;
                    case 7:
                        num=8;
                        break;
                    case 8:
                        num=9;
                        break;
                    case 9:
                        num=10;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tools_name:
               /* String[] strings=new String[new Random().nextInt(50)+10];
                for (int i = 0; i <strings.length; i++) {
                    strings[i]="元素"+i;
                }
                pickerViewPop.showPopupWindow(statistics_element, BaseApplication.getInstance().getContext(),strings
                ).setOnPickerViewListen(new PickerViewPop.OnPickerViewListen() {
                    @Override
                    public void OnConfirm(int index, String text) {
                        statistics_element.setText(text+"");
                    }
                });*/
                break;
            case R.id.tools_size:
                break;
            case R.id.rearch_btn:
                setDate();
                break;

        }
    }

    public void setDate(){
        switch (num){
            case 10:
                mTextContent.setText(""+str1[9]);
                mTextContent2.setText(""+str2[9]);
                break;
            case 1:
                mTextContent.setText(""+str1[0]);
                mTextContent2.setText(""+str2[0]);
                break;
            case 2:
                mTextContent.setText(""+str1[1]);
                mTextContent2.setText(""+str2[1]);
                break;
            case 3:
                mTextContent.setText(""+str1[2]);
                mTextContent2.setText(""+str2[2]);
                break;
            case 4:
                mTextContent.setText(""+str1[3]);
                mTextContent2.setText(""+str2[3]);
                break;
            case 5:
                mTextContent.setText(""+str1[4]);
                mTextContent2.setText(""+str2[4]);
                break;
            case 6:
                mTextContent.setText(""+str1[5]);
                mTextContent2.setText(""+str2[5]);
                break;
            case 7:
                mTextContent.setText(""+str1[6]);
                mTextContent2.setText(""+str2[6]);
                break;
            case 8:
                mTextContent.setText(""+str1[7]);
                mTextContent2.setText(""+str2[7]);
                break;
            case 9:
                mTextContent.setText(""+str1[8]);
                mTextContent2.setText(""+str2[8]);
                break;
        }
    }
}
