package com.example.mayn.elevatorapplication.Fragment.fragment_home;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.mayn.elevatorapplication.R;
import com.example.mayn.elevatorapplication.ui.XListViewActivity;
import com.example.mayn.elevatorapplication.widget.XListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Fragment_tuijian extends Fragment implements XListView.IXListViewListener {
    private XListView mListView;

    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> items = new ArrayList<String>();
    private Handler mHandler;
    private int mIndex = 0;
    private int mRefreshIndex = 0;

    public static void launch(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, XListViewActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
        context.startActivity(intent);
    }

    private  View view;
        private Context mcontext;

    public Fragment_tuijian() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.fragment_tuijian,null);
        geneItems();
        initView();
       return view;
    }
    private void initView() {
        mHandler = new Handler();

        mListView = (XListView) view.findViewById(R.id.list_view);
        mListView.setPullRefreshEnable(true);
        mListView.setPullLoadEnable(true);
        mListView.setAutoLoadEnable(true);
        mListView.setXListViewListener(this);
        mListView.setRefreshTime(getTime());

        mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.vw_list_item, items);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"item"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.getActivity().onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            mListView.autoRefresh();
        }
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mIndex = ++mRefreshIndex;
                items.clear();
                geneItems();
                mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.vw_list_item,
                        items);
                mListView.setAdapter(mAdapter);
                onLoad();
            }
        }, 2500);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                geneItems();
                mAdapter.notifyDataSetChanged();
                onLoad();
            }
        }, 2500);
    }

    private void geneItems() {
        for (int i = 0; i != 20; ++i) {
            items.add("ListView item " + (++mIndex));
        }
    }

    private void onLoad() {
        mListView.stopRefresh();
        mListView.stopLoadMore();
        mListView.setRefreshTime(getTime());
    }

    private String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }
}
