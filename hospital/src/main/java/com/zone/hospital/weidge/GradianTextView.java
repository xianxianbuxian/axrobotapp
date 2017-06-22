package com.zone.hospital.weidge;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

import com.zone.hospital.R;

/**
 * Created by zone on 2017/4/11.
 */

public class GradianTextView extends TextView {
    public GradianTextView(Context context) {
        super(context);
    }

    public GradianTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GradianTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GradianTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.anti1));

        ValueAnimator animator = ValueAnimator.ofFloat(0, 180);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                paint.setAlpha((Integer) animation.getAnimatedValue());
            }
        });

    }
}
