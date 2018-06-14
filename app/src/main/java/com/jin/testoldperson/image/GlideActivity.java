package com.jin.testoldperson.image;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.jin.testoldperson.R;

public class GlideActivity extends Activity {
    private ImageView iv1;
    private ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        iv1 = findViewById(R.id.iv1);
        setIv1();

        iv2 = findViewById(R.id.iv2);
        setIv2();


    }

    private void setIv2() {
        GlideApp.with(this)
                .load("http://06.php.jxcraft.net/public/uploads/img/20180611/fd2b4221f63e9c4980569a4943a40e27.jpg").
                placeholder(R.mipmap.ic_launcher)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        e.logRootCauses("glide");
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(iv2);
    }

    private void setIv1() {
        Glide.with(this).load("http://img.zcool.cn/community/0142135541fe180000019ae9b8cf86.jpg@1280w_1l_2o_100sh.png").into(iv1);
    }
}
