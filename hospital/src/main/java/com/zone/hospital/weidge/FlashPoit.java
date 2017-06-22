package com.zone.hospital.weidge;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

/**
 * Created by zone on 2017/4/12.
 */

public class FlashPoit extends View {

    private boolean mIsAnimatorPlaying = false;
    private Paint mPaint2;
    private Point movePoit;
    private int mRadius;

    public FlashPoit(Context context) {
        super(context);
        init();
    }

    private void initscaleanim() {
        ScaleAnimation mSaim=new ScaleAnimation(1f,2.0f,1f,2.0f, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        mSaim.setDuration(1000);
        mSaim.setRepeatMode(ScaleAnimation.INFINITE);
        mSaim.setRepeatCount(Integer.MAX_VALUE);
        mSaim.setFillAfter(true);
        mSaim.start();
    }

    private void init() {
        mRadius = 25;
        mPaint2 = new Paint();
        mPaint2.setColor(Color.BLUE);
        mPaint2.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint2.setAntiAlias(true);
        movePoit = new Point(getWidth() / 2, getHeight() / 2);
    }

    public FlashPoit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public FlashPoit(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FlashPoit(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init();

    }



    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, mRadius, mPaint2);

//        if (!mIsAnimatorPlaying) {
//            mIsAnimatorPlaying = true;
//            ValueAnimator animator = ValueAnimator.ofInt(0, 100);
//            animator.setDuration(2000);
//            animator.setRepeatCount(ValueAnimator.INFINITE);
//            animator.setRepeatMode(ValueAnimator.REVERSE);
//            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation) {
//                    int alpha = (int) animation.getAnimatedValue();
//                      mPaint2.setAlpha(alpha);
//                    invalidate();
//                    Log.d("zoneLog", String.valueOf(alpha));
//                }
//            });
//            animator.start();
//            Log.d("zoneLog", "开始");
//        }
    }
}
