package com.jin.testoldperson.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by my on 2018/5/15.
 */

public class TwinkleTextView extends View {
    private Paint textPaint = new Paint();
    private Path path = new Path();
    private LinearGradient mLinearGradient;

    public TwinkleTextView(Context context) {
        super(context);
    }

    public TwinkleTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TwinkleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        textPaint.setStrokeWidth(5);
        textPaint.setColor(Color.RED);
        textPaint.setStyle(Paint.Style.STROKE);
        path.moveTo(25, 0);
        path.lineTo(0, 25);
        path.moveTo(25, 0);
        path.lineTo(50, 25);
        mLinearGradient = new LinearGradient(0, 0, 25, 0, new int[]{Color.RED, Color.GREEN, Color.CYAN, 0xffffffff, Color.BLUE}, null, Shader.TileMode.CLAMP);
        textPaint.setShader(mLinearGradient);
        canvas.drawPath(path, textPaint);
        postInvalidateDelayed(200);

    }
}
