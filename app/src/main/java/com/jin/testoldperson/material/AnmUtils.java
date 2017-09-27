package com.jin.testoldperson.material;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

/**
 * Created by my on 2017/9/22.
 */

public class AnmUtils {
    public void roundLoad(View myView) {
        int cx = (myView.getLeft() + myView.getRight()) / 2;
        int cy = (myView.getTop() + myView.getBottom()) / 2;

        // get the final radius for the clipping circle
        int finalRadius = Math.max(myView.getWidth(), myView.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        // create the animator for this view (the start radius is zero)
        // 要求最小api 为21
        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);
        anim.setDuration(1000);
        anim.setInterpolator(new AccelerateInterpolator());

        Animator anim1 = ObjectAnimator.ofFloat(myView, "translationZ", 0f, 50f);
        anim1.setDuration(1500);
        anim1.setInterpolator(new AccelerateInterpolator());

        animatorSet.play(anim).with(anim1);
        // make the view visible and start the animation
        myView.setVisibility(View.VISIBLE);
        animatorSet.start();
    }

    public static  void roundLoadBig(View view) {
        ObjectAnimator revealAnimator = ObjectAnimator.ofFloat( //缩放X 轴的
                view, "scaleX", 0, 200);
        ObjectAnimator revealAnimator1 = ObjectAnimator.ofFloat(//缩放Y 轴的
                view, "scaleY", 0, 200);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);//设置播放时间
        set.setInterpolator(new LinearInterpolator());//设置播放模式，这里是平常模式
        set.playTogether(revealAnimator, revealAnimator1);//设置一起播放
        set.start();
    }
    public static  void roundLoadSmall(View view) {
        ObjectAnimator revealAnimator = ObjectAnimator.ofFloat( //缩放X 轴的
                view, "scaleX", 200, 0);
        ObjectAnimator revealAnimator1 = ObjectAnimator.ofFloat(//缩放Y 轴的
                view, "scaleY", 200,0);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(5000);//设置播放时间
        set.setInterpolator(new LinearInterpolator());//设置播放模式，这里是平常模式
        set.playTogether(revealAnimator, revealAnimator1);//设置一起播放
        set.start();
    }
}
