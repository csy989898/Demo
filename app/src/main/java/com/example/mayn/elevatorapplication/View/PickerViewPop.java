/*
package com.example.mayn.elevatorapplication.View;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.mayn.elevatorapplication.R;

public class PickerViewPop {

    private PopupWindow popupWindow;


    public PickerViewPop showPopupWindow(View view, Context context, String[] str) {
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(context).inflate(
                R.layout.picker_view, null);
        // 设置按钮的点击事件
        setContentView(contentView, str);

        popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        popupWindow.setTouchable(true);

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.i("mengdd", "onTouch : ");

                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        // 设置好参数之后再show
        popupWindow.showAsDropDown(view);


        return this;
    }
    public interface OnPickerViewListen {
        void OnConfirm(int index, String text);
    }

    private OnPickerViewListen onPickerViewListen;

    public void setOnPickerViewListen(OnPickerViewListen onPickerViewListen) {
        this.onPickerViewListen = onPickerViewListen;
    }

    public void setContentView(View contentView, final String[] str) {
        final PickerView pickerView = (PickerView) contentView.findViewById(R.id.picker_view);
        TextView confirm = (TextView) contentView.findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onPickerViewListen!=null){
                    int index=pickerView.getSelectedTextIndex();
                    onPickerViewListen.OnConfirm(index,str[index]);
                    popupWindow.dismiss();
                }
            }
        });
        pickerView.setTextString(str);
    }

}
*/
