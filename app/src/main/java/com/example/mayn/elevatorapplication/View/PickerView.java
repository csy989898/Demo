/*
package com.example.mayn.elevatorapplication.View;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.math.BigDecimal;

public class PickerView  extends View {
    private String TAG = "PickerView";
    */
/**
     * 数据
     *//*

    private String[] strings = new String[]{};
    */
/**
     * 控件宽度
     *//*

    private int mViewWidth;

    */
/**
     * 控件高度
     *//*

    private int mViewHeight;

    */
/**
     * 文本画笔
     *//*

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    */
/**
     * 中间线画笔
     *//*

    private Paint mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    */
/**
     * 中间线边距
     *//*

    private int linePading = 10;

    */
/**
     * 绘制文字大小
     *//*

    private int textSezi = 14;
    */
/**
     * 中间线的厚度
     *//*

    private float lineWidth = 1;
    */
/**
     * 选中的颜色
     *//*

    private int checkedColor = 0xFFFF0000;
    */
/**
     * 未选中的颜色
     *//*

    private int notCheckedColor = 0xFF000000;

    */
/**
     * 看见的条目数量,必须奇数
     *//*

    private int weight = 5;

    private int itemHeight;
    */
/**
     * 当前的位置
     *//*

    private int index;

    */
/**
     * 默认选中中间位置
     *//*

    private int defaultIndex = -1;


    private int checkedIndex = (weight - 1) / 2;
    private float mMoveLen;

    public PickerView(Context context) {
        super(context);
        init();
    }

    */
/**
     * 设置默认选中位置
     *//*

    public void setDefaultIndex(int defaultIndex) {
        this.defaultIndex = defaultIndex;
    }

    public PickerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public PickerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mViewHeight = getMeasuredHeight();
        mViewWidth = getMeasuredWidth();
        itemHeight = mViewHeight / weight;


        if (defaultIndex == -1) {
            */
/**设置默认中间位置*//*

            defaultIndex = strings.length / 2;
        }

        mMoveLen = -itemHeight * (defaultIndex - (weight - 1) / 2);
        this.index = defaultIndex;
    }

    */
/**
     * 设置整个控件可视条目数量
     *//*

    public void setWeight(int weight) {
        this.weight = weight;
    }

    */
/**
     * 获取选中的位置
     *//*

    public int getSelectedTextIndex() {
        return index;
    }

    */
/**
     * 设置text文本数组
     *//*

    public void setTextString(String[] strings) {
        this.strings = strings;
    }

    private void setSelectedText(int index) {
        this.index = index;
    }

    */
/**
     * 设置绘制文字大小
     *//*

    public void setTextSezi(int textSezi) {
        this.textSezi = textSezi;
    }

    */
/**
     * 设置绘制中间线边距
     *//*

    public void setLinePading(int linePading) {
        this.linePading = linePading;
    }


    */
/**
     * 设置中间线的厚度
     *//*

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    */
/**
     * 设置选中时的文本颜色
     *//*

    public void setCheckedColor(int checkedColor) {
        this.checkedColor = checkedColor;
    }

    */
/***设置未选中时的文本颜色*//*

    public void setNotCheckedColor(int notCheckedColor) {
        this.notCheckedColor = notCheckedColor;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        */
/**绘制文字*//*

        drwaText(canvas);
        */
/**绘制中间线*//*

        drwaLine(canvas);

    }

    */
/**
     * 绘制文字
     *
     * @param canvas
     *//*

    private void drwaText(Canvas canvas) {
        for (int i = 0; i < strings.length; i++) {
            */
/**绘制可视范围文本*//*

            if (i + weight -1 > index && i - weight+1 < index) {

                if (i == index) {
                    mPaint.setColor(checkedColor);

                } else {
                    mPaint.setColor(notCheckedColor);
                }

                Paint.FontMetrics metrics = mPaint.getFontMetrics();
                float textHeight = metrics.descent; //文字高度
                canvas.drawText(strings[i], mViewWidth / 2, itemHeight * (i + 1) - itemHeight / 2 + mMoveLen + textHeight, mPaint);
            }
        }
    }

    */
/**
     * 绘制中间线
     *//*

    private void drwaLine(Canvas canvas) {
        int pading = DipToPx.dip2px(linePading);
        canvas.drawLine(pading, itemHeight * checkedIndex, getRight() - pading, itemHeight * checkedIndex, mLinePaint);
        canvas.drawLine(pading, itemHeight * (checkedIndex + 1), getRight() - pading, itemHeight * (checkedIndex + 1), mLinePaint);
    }


    */
/**
     * 初始化画笔
     *//*

    private void init() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextAlign(Paint.Align.CENTER);//绘制文本横向居中
        mPaint.setTextSize(DipToPx.dip2px(textSezi));


        mLinePaint.setStyle(Paint.Style.FILL);
        mLinePaint.setTextAlign(Paint.Align.CENTER);
        mLinePaint.setStrokeWidth(lineWidth);

    }

    */
/**
     * 更新画笔参数
     *//*

    public void updatePaint() {
        init();
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                doDown(event);
                break;
            case MotionEvent.ACTION_MOVE:
                doMove(event);
                break;
            case MotionEvent.ACTION_UP:
                doUp(event);
                break;
        }
        return true;
    }

    private void doUp(MotionEvent event) {
        float indexes = mMoveLen / itemHeight;

        */
/**四舍五入 来判定离哪个位置较近*//*

        BigDecimal dex = new BigDecimal(indexes).setScale(0, BigDecimal.ROUND_HALF_UP);
        float newIndex = dex.floatValue();
        mMoveLen = newIndex * itemHeight;
        int location;
        */
/*限制角标0的移动范围*//*

        if (newIndex >= checkedIndex + 1) {
            mMoveLen = checkedIndex * itemHeight;

        }
        */
/*限制最后一个单位的移动  移动范围*//*

        if (newIndex <= -(strings.length - checkedIndex - 1)) {
            mMoveLen = -((strings.length - checkedIndex - 1) * itemHeight);
        }
        //  Log.i("newIndex",newIndex+"");
        */
/**防止选中角标越界*//*

        if (newIndex >= 0) {
            location = (int) (checkedIndex - newIndex);
            if (newIndex >= checkedIndex + 1) {
                location = 0;
            }
        } else {
            location = (int) (Math.abs(newIndex) + checkedIndex);
            if (location > strings.length - 1) {
                location = strings.length - 1;
            }
        }
        */
/**滑动停止的时候设置当前选中的 是第几个*//*

        setSelectedText(location);
        invalidate();
    }


    private void doMove(MotionEvent event) {

        int location;
        mMoveLen += (event.getY() - mLastDownY);
        mLastDownY = event.getY();
        float indexes = mMoveLen / itemHeight;
        */
/**四舍五入 来判定离哪个位置较近*//*

        BigDecimal dex = new BigDecimal(indexes).setScale(0, BigDecimal.ROUND_HALF_UP);
        float newIndex = dex.floatValue();


        */
/**防止选中角标越界*//*

        if (newIndex >= 0) {
            location = (int) (checkedIndex - newIndex);
            if (newIndex >= checkedIndex + 1) {
                location = 0;
            }
        } else {
            location = (int) (Math.abs(newIndex) + checkedIndex);
            if (location > strings.length - 1) {
                location = strings.length - 1;
            }
        }
        setSelectedText(location);
        invalidate();
    }

    private float mLastDownY;

    private void doDown(MotionEvent event) {
        mLastDownY = event.getY();
    }
}
*/
