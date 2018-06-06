package com.jin.testoldperson.textview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.jin.testoldperson.R;

public class AddressEditText extends EditText implements View.OnFocusChangeListener {
    private Context context;


    public void setOnCheckInputListener(OnCheckInputListener onCheckInputListener) {
        this.onCheckInputListener = onCheckInputListener;
    }

    private OnCheckInputListener onCheckInputListener;
    private GradientDrawable drawable;

    /**
     * 检测输入是否符合要求的回调
     */
    public interface OnCheckInputListener {
        /**
         * 检测输入的方法
         *
         * @param v   点击的view
         * @param str 输入的字符串
         * @return 检测成功返回true, 检测失败返回false
         */
        boolean checkInput(View v, String str);
    }

    public AddressEditText(Context context) {
        this(context, null);
    }

    public AddressEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayerDrawable layerDrawable = (LayerDrawable) getBackground();
        drawable = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.shape);
        setOnFocusChangeListener(this);
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {

            drawable.setStroke(2,context.getColor(R.color.green));
        } else {
            drawable.setStroke(1, context.getColor(R.color.colorPrimary));
           /* if (onCheckInputListener != null && onCheckInputListener.checkInput(this, getText().toString().trim())) {
                drawable.setStroke(ResourceUtil.getDimens(R.dimen.dp_1), ResourceUtil.getColor(R.color.color_f1f1f1));

            } else if (onCheckInputListener == null) {
                drawable.setStroke(ResourceUtil.getDimens(R.dimen.dp_1), ResourceUtil.getColor(R.color.color_f1f1f1));
            } else {
                drawable.setStroke(ResourceUtil.getDimens(R.dimen.dp_1), ResourceUtil.getColor(R.color.color_ff6f00));

            }*/
        }
    }
}

