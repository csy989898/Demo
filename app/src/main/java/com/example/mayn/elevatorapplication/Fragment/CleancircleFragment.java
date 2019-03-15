package com.example.mayn.elevatorapplication.Fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.SupportMapFragment;
import com.baidu.mapapi.model.LatLng;
import com.example.mayn.elevatorapplication.CheckRecordBean;
import com.example.mayn.elevatorapplication.R;
import com.example.mayn.elevatorapplication.RecoverPasswdActivity;
import com.example.mayn.elevatorapplication.View.InfoWindowHolder;

import java.util.ArrayList;
import java.util.List;

import utils.StringUtils;


public class CleancircleFragment extends Fragment implements View.OnClickListener{

    public CleancircleFragment() {
    }

    private MapView mMapView;
    private BaiduMap mBaiduMap;
    public LocationClient mLocationClient;
    public BDLocationListener myListener = new MyLocationListener();
    private Button map_bt;
    private Button button;
    private Button buttons;
    private Button button1;
    private LatLng latLng;
    private boolean isFirstLoc = true; // 是否首次定位
    private View view;


    private static final int   REQUEST_CHECKMAP = 200;
    private View               rootview;
    private ProgressDialog mDialog;
    private Handler mHandler;
    private SupportMapFragment map;
    private BitmapDescriptor   descriptor;

    /**
     *@Fields mInfoWindow : 弹出的窗口
     */
    private InfoWindow mInfoWindow;
    private LinearLayout baidumap_infowindow;
    private MarkerOnInfoWindowClickListener markerListener;

    private void initView1(View rootView){

        baidumap_infowindow = (LinearLayout) LayoutInflater.from (getActivity ()).inflate (R.layout.baidumap_infowindow, null);

        // 构建Marker图标
        descriptor = BitmapDescriptorFactory.fromResource (R.mipmap.ico_sign_01);

        mHandler = new AsyncHandler ();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SDKInitializer.initialize(getActivity().getApplicationContext());
        view = inflater.inflate(R.layout.fragment_circle, container, false);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        initView();
        initMap();
        initView1(view);
        setinitMaps ();
        test ();
        return view;
    }


    private void initMap() {
        //获取地图控件引用
        mBaiduMap = mMapView.getMap();
        //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mBaiduMap.setMyLocationEnabled(true);

        //默认显示普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        //开启交通图
        mBaiduMap.setTrafficEnabled(true);
        //开启热力图
       // mBaiduMap.setBaiduHeatMapEnabled(true);
        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        mLocationClient = new LocationClient(getActivity().getApplicationContext());     //声明LocationClient类
        //配置定位SDK参数
        initLocation();
        mLocationClient.registerLocationListener(myListener);    //注册监听函数
        //开启定位
        mLocationClient.start();
        //图片点击事件，回到定位点
        mLocationClient.requestLocation();

    }

    public void setinitMaps(){
        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo (14.0f);
        mBaiduMap.setMapStatus (msu);
        markerListener = new MarkerOnInfoWindowClickListener ();
        //对Marker的点击事件
        mBaiduMap.setOnMarkerClickListener (new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker){
                //获得marker中的数据
                CheckRecordBean bean = (CheckRecordBean) marker.getExtraInfo ().get ("marker");
                createInfoWindow(baidumap_infowindow, bean);
                //将marker所在的经纬度的信息转化成屏幕上的坐标
                final LatLng ll = marker.getPosition();
                mInfoWindow = new InfoWindow (BitmapDescriptorFactory.fromView (baidumap_infowindow), ll, -47, markerListener);
                //显示InfoWindow
                mBaiduMap.showInfoWindow(mInfoWindow);
                return true;
            }
        });
    }

    /*private void initData(){
        mDialog = ProgressDialogUtils.showProgressDialog (getActivity (), R.string.progress_title, R.string.progress_message);
        AsyncCheckMap checkMap = new AsyncCheckMap (getActivity (),mDialog,mHandler,REQUEST_CHECKMAP);
        checkMap.execute ();
    }*/


    private final class  MarkerOnInfoWindowClickListener implements InfoWindow.OnInfoWindowClickListener {
        @Override
        public void onInfoWindowClick(){
            //隐藏InfoWindow
            mBaiduMap.hideInfoWindow();
        }
    }

    /**
     *@Description: 创建 弹出窗口
     *@param baidumap_infowindow
     *@param bean
     */
    @SuppressLint("StringFormatInvalid")
    private void createInfoWindow(LinearLayout baidumap_infowindow, CheckRecordBean bean){

        InfoWindowHolder holder = null;
        if(baidumap_infowindow.getTag () == null){
            holder = new InfoWindowHolder ();

            holder.tv_entname = (TextView) baidumap_infowindow.findViewById (R.id.tv_entname);
            holder.tv_checkdept = (TextView) baidumap_infowindow.findViewById (R.id.tv_checkdept);
            holder.tv_checkuser = (TextView) baidumap_infowindow.findViewById (R.id.tv_checkuser);
            holder.tv_checktime = (TextView) baidumap_infowindow.findViewById (R.id.tv_checktime);
            baidumap_infowindow.setTag (holder);
        }

        holder = (InfoWindowHolder) baidumap_infowindow.getTag ();

        holder.tv_entname.setText (String.format (getString (R.string.checkmap_entname_format), bean.getEntName ()));
        holder.tv_checkdept.setText (String.format (getString (R.string.checkmap_checkdept_format), bean.getRemark1 ()));
        holder.tv_checkuser.setText (String.format (getString (R.string.checkmap_checkuser_format), bean.getCheckUserNames ()));
        holder.tv_checktime.setText (String.format (getString (R.string.checkmap_checktime_format), bean.getCheckTime ()));
    }


    //配置定位SDK参数
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation
        // .getLocationDescribe里得到，结果类似于“在****附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);
        option.setOpenGps(true); // 打开gps

        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    /*显示指定位置的地图*/
    public void setUpdateDate(){
        //初始化地图
        mBaiduMap = mMapView.getMap();
        //设定中心点坐标
        LatLng cenpt = new LatLng(31.006651,121.45);
        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.mipmap.ico_sign_01);
        OverlayOptions options= new MarkerOptions() .position(cenpt) .icon(bitmap) .draggable(true); //在地图上添加Marker，并显示
        mBaiduMap.addOverlay(options);

        //定义地图状态
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(cenpt)
                .zoom(18)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        //改变地图状态
        mBaiduMap.setMapStatus(mMapStatusUpdate);
    }

    //实现BDLocationListener接口,BDLocationListener为结果监听接口，异步获取定位结果
    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            /*
            百度地图添加自定义Marker图标*/
            LatLng point = new LatLng(location.getLatitude(), location.getLongitude()); //构建Marker图标
            BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.mipmap.ico_sign_02); //构建MarkerOption，用于在地图上添加Marker
            OverlayOptions options= new MarkerOptions() .position(point) .icon(bitmap) .draggable(true); //在地图上添加Marker，并显示
            mBaiduMap.addOverlay(options);
            /*Marker marker;//marker的初始化与要定位的坐标相关
            marker.setIcon(bitmap);*/

            latLng = new LatLng(location.getLatitude(), location.getLongitude());
            // 构造定位数据
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            // 设置定位数据
            mBaiduMap.setMyLocationData(locData);
            // 当不需要定位图层时关闭定位图层
            //mBaiduMap.setMyLocationEnabled(false);
            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(18.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));

                if (location.getLocType() == BDLocation.TypeGpsLocation) {
                    // GPS定位结果
                    Toast.makeText(getActivity(), location.getAddrStr(), Toast.LENGTH_SHORT).show();
                } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
                    // 网络定位结果
                    Toast.makeText(getActivity(), location.getAddrStr(), Toast.LENGTH_SHORT).show();

                } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {
                    // 离线定位结果
                    Toast.makeText(getActivity(), location.getAddrStr(), Toast.LENGTH_SHORT).show();

                } else if (location.getLocType() == BDLocation.TypeServerError) {
                    Toast.makeText(getActivity(), "服务器错误，请检查", Toast.LENGTH_SHORT).show();
                } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                    Toast.makeText(getActivity(), "网络错误，请检查", Toast.LENGTH_SHORT).show();
                } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                    Toast.makeText(getActivity(), "手机模式错误，请检查是否飞行", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void initView() {
        mMapView = (MapView) view.findViewById(R.id.bmapView);
        map_bt = (Button) view.findViewById(R.id.map_bt);
        map_bt.setOnClickListener(this);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);
        buttons = (Button) view.findViewById(R.id.buttons);
        buttons.setOnClickListener(this);
        button1 = (Button) view.findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    @Override
    public void onStart(){
        super.onStart ();
        /*setinitMaps ();
        test ();*/
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.map_bt:
                //把定位点再次显现出来
                MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(latLng);
                mBaiduMap.animateMapStatus(mapStatusUpdate);
                break;
            case R.id.button:
                //卫星地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.buttons:
                //普通地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case R.id.button1:
               setUpdateDate();
                break;
        }
    }


    private final class AsyncHandler extends Handler {
        @Override
        public void handleMessage(Message msg){
            String result = (String) msg.obj;
            switch (msg.what) {
                case REQUEST_CHECKMAP:// 检查地图
                    List<CheckRecordBean> list = JSONUtils.parseArray (result, CheckRecordBean.class);
                    if (list != null) {
                        showData (list);
                    } else {
                        Toast.makeText(getActivity(),"app_serviceReturn——-----------Error",Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }
    }

    private void test(){

        List<CheckRecordBean> list = new ArrayList<CheckRecordBean>();

        CheckRecordBean bean = new CheckRecordBean ();
        bean.setEntName ("杭州鸿雁电器有限公司");
        bean.setCheckTime ("2015-09-19");
        bean.setCheckUserNames ("杨攀");
        bean.setRemark1 ("综合科");
        bean.setCheckX ("31.963175");
        bean.setCheckY ("121.400244");

        list.add (bean);

        CheckRecordBean bean2 = new CheckRecordBean();
        bean2.setEntName ("杭州图讯科技有限公司");
        bean2.setCheckTime ("2015-09-19");
        bean2.setCheckUserNames ("赵云");
        bean2.setRemark1 ("管理科");
        bean2.setCheckX ("31.962173");
        bean2.setCheckY ("121.410294");

        list.add (bean2);

        showData (list);
    }

    /**
     *@Description: 显示 数据
     *@param list
     */
    private void showData(List<CheckRecordBean> list){
        mBaiduMap.clear ();
        addMarker (list);
    }


    /**
     *@Description: 添加 标记
     *@param list
     */
    private void addMarker(List<CheckRecordBean> list){
        for ( int i = 0 ; i < list.size () ; i++ ) {
            CheckRecordBean bean = list.get (i);
            // 经度
            double longitude = parseLatLng (bean.getCheckY ());
            // 纬度
            double latitude = parseLatLng (bean.getCheckX ());

            if (longitude > 0 && latitude > 0) {
                // 定义Maker坐标点
                LatLng ll = new LatLng (latitude,longitude);
                // 构建MarkerOption，用于在地图上添加Marker
                MarkerOptions options = new MarkerOptions ().position (ll).icon (descriptor);
                // 在地图上添加Marker，并显示
                Marker marker1 = (Marker) mBaiduMap.addOverlay (options);
                // 将信息保存
                Bundle bundle = new Bundle ();
                bundle.putSerializable ("marker", bean);
                Log.e("",""+list.get(1));
                marker1.setExtraInfo (bundle);

                if (i == 0) {
                    // 把第一个默认为当前的位置图层
                    MapStatusUpdate u = MapStatusUpdateFactory.newLatLng (ll);
                    mBaiduMap.setMapStatus (u);
                }
            }
        }
    }

    private double parseLatLng(String latlng){
        if (!TextUtils.isEmpty (latlng)) { return Double.parseDouble (latlng); }
        return -1;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged (newConfig);
    }



    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

}
