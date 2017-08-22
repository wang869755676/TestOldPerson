package com.jin.testoldperson.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    int phase ;
    public MyView(Context context) {
        super(context);
        phase = 0;
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        phase = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        setBackgroundColor(Color.CYAN);

        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.WHITE);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(2.0f);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{8,10,8,10},phase);
        p.setPathEffect(dashPathEffect);

        Path path = new Path();
        path.moveTo(200, 600);
        path.lineTo(800, 600);

        canvas.drawPath(path,p);

        phase++;
        // 重绘，产生动画效果
        invalidate();

    }
}