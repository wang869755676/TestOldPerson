package com.jin.testoldperson.paint;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by my on 2017/7/12.
 */

public class PaintView extends View {
    private Paint paint;

    public PaintView(Context context) {
        super(context);
        init();
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setPathEffect(new DashPathEffect(new float[]{10, 10, 10, 10}, 0));
    }

    @Override
    protected void onDraw(Canvas canvas) {
       // canvas.drawArc(new RectF(100, 100, 100, 100), 30, 270, false, paint);
        canvas.drawLine(0,0,200,200, paint);
    }
}
