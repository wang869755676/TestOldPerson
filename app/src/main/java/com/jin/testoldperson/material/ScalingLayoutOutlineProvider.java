package com.jin.testoldperson.material;

import android.graphics.Outline;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewOutlineProvider;

import static android.R.attr.radius;
import static android.R.attr.width;
import static android.support.v7.appcompat.R.attr.height;

/*自定义阴影*/
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ScalingLayoutOutlineProvider extends ViewOutlineProvider {

    @Override
    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, width, height, radius);
    }
}

