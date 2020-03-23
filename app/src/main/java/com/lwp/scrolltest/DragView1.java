package com.lwp.scrolltest;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class DragView1 extends View {

    private int lastX;
    private int lastY;

    private final String TAG = "heheda";
    //1.三个构函
    public DragView1(Context context) {
        super(context);
        ininView();// 给View设置背景颜色，便于观察
    }

    public DragView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        ininView();
    }

    public DragView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView();
    }

    //2.涂色
    private void ininView() {
        // 给View设置背景颜色，便于观察
        setBackgroundColor(Color.BLUE);
    }

    // 视图坐标方式       3.
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        Log.d(TAG, "onTouchEvent event.getX(): "+event.getX());
        int y = (int) event.getY();
        Log.d(TAG, "onTouchEvent event.getY(): "+event.getY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录触摸点坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                // 计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                // 在当前left、top、right、bottom的基础上加上偏移量  将计算出来的偏移量递给layout()，完成view的移动
//                layout(getLeft() + offsetX,
//                        getTop() + offsetY,
//                        getRight() + offsetX,
//                        getBottom() + offsetY);
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                break;
        }
        return true;
    }
}
