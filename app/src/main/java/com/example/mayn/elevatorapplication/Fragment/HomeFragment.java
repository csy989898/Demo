package com.example.mayn.elevatorapplication.Fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.mayn.elevatorapplication.Fragment.fragment_home.Fragment_hangye;
import com.example.mayn.elevatorapplication.Fragment.fragment_home.Fragment_tuijian;
import com.example.mayn.elevatorapplication.R;
import com.example.mayn.elevatorapplication.Utils.Search.SearchAdapter;

public class HomeFragment extends android.support.v4.app.Fragment implements View.OnClickListener{
    private View view;
    public HomeFragment() {
    }

    private String[] mStrs = {"kk", "kk", "wskx", "wksx"};
    private SearchView mSearchView;
    private ListView lListView;

    private TabLayout mTablayout;
    private ViewPager mTabViewpager;
    private Fragment[] mFragmentArrays = new Fragment[2];
    private String[] mTabTitles = new String[2];

    private ImageView empty;
    private AutoCompleteTextView search;
    private String[] str = {"aaa", "bbb", "ccc", "ddd", "eee", "fff","ssss", "tttt","uuuu", "vvvv", "www", "xxxx",
            "gggg", "hhhh","iii", "jjj", "kkkk", "llll","mmm", "nnnn","ooo", "ppp", "qqq", "rrr","yyyy","zzz"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

       /*
*/
        mTablayout = (TabLayout)view. findViewById(R.id.tablayout);
        mTabViewpager = (ViewPager) view.findViewById(R.id.tab_viewpager);
        mTabTitles[0] = "推荐";
        mTabTitles[1] = "行业";
        mTablayout.setTabMode(TabLayout.MODE_FIXED);
        mFragmentArrays[0] =new Fragment_tuijian();
        //mFragmentArrays[1] = TabFragment.newInstance();
        mFragmentArrays[1] = new Fragment_hangye();
        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getActivity().getSupportFragmentManager());
        mTabViewpager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        mTablayout.setupWithViewPager(mTabViewpager);
        setSearch();
        return view;
    }


    final class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrays[position];
        }


        @Override
        public int getCount() {
            return mFragmentArrays.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];
        }
    }


    public void setSearch(){
        empty = (ImageView) view.findViewById(R.id.empty);
        empty.setOnClickListener(this);
        search = (AutoCompleteTextView) view.findViewById(R.id.search);
        // 自动提示适配器
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        // 支持拼音检索
        SearchAdapter<String> adapter = new SearchAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, str, SearchAdapter.ALL);
        search.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.empty:
                search.setText("");
                break;
        }
    }




/*public void setSearchDate(){
        mSearchView = (SearchView) view.findViewById( R.id.searchView);
        lListView = (ListView) view.findViewById(R.id.listView);
        lListView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mStrs));
        lListView.setTextFilterEnabled(true);

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    lListView.setFilterText(newText);
                }else{
                    lListView.clearTextFilter();
                }
                return false;
            }
        });
    }*/

}