package com.jin.testoldperson.ViewAnimator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

import com.jin.testoldperson.R;
import com.jin.testoldperson.recyclerviewt.RecyclerViewActivity;

public class ViewAnimatorActivity extends Activity {
    private ImageSwitcher imageSwitcher;
    private TextSwitcher  textSwitcher;
    private ViewFlipper viewFlipper;
    private int i=0;

    private int[] resImage={R.mipmap.ic_launcher,R.mipmap.icon_clear,R.mipmap.icon_collection,R.mipmap.icon_default};
    private String[] resTv={"one","two","three","four"};
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animator);
        imageSwitcher= (ImageSwitcher) findViewById(R.id.imageSwitcher);
        textSwitcher= (TextSwitcher) findViewById(R.id.textSwitcher);
        viewFlipper= (ViewFlipper) findViewById(R.id.viewFlipper);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                // 创建ImageView对象
                ImageView imageView = new ImageView(ViewAnimatorActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                // 返回ImageView对象
                return imageView;
            }
        });

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                final TextView tv = new TextView(ViewAnimatorActivity.this);
                //设置文字大小

                //设置文字 颜色
                tv.setTextColor(Color.BLACK);
                tv.setSingleLine();
                tv.setEllipsize(TextUtils.TruncateAt.END);
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.gravity = Gravity.CENTER;
                tv.setLayoutParams(lp);
                //内容的点击事件
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                return tv;
            }
        });

        viewFlipper.isAutoStart();
        viewFlipper.isFlipping();
        viewFlipper.startFlipping();

        runnable=new Runnable() {
            @Override
            public void run() {
                imageSwitcher.setImageResource(resImage[i]);
                textSwitcher.setText(resTv[i]);
                if(i==resImage.length-1){
                    i=-1;
                }
                i++;
                handler.postDelayed(this,1000);

            }
        };
        handler.post(runnable);

    }
    private Runnable runnable;
}
