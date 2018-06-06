package com.jin.testoldperson.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.FloatProperty;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by my on 2018/5/15.
 */

public class RadiusTransition extends Transition {
    private Float startingRadius;
    private Float endingRadius;
    private final String PROPNAME_RADIUS = "RadiusTransition:radius";


    public RadiusTransition(Float startingRadius, Float endingRadius) {
        this.startingRadius = startingRadius;
        this.endingRadius = endingRadius;
    }

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        if (transitionValues.view instanceof ImageView) {
            transitionValues.values.put(PROPNAME_RADIUS, startingRadius);
        }
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        if (transitionValues.view instanceof ImageView) {
            transitionValues.values.put(PROPNAME_RADIUS, endingRadius);
        }
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {

        if (startValues == null || endValues == null) {
            return null;
        }

        ImageView endImageView = (ImageView) endValues.view;
        Float start = (Float) startValues.values.get(PROPNAME_RADIUS);
        Float end = (Float) endValues.values.get(PROPNAME_RADIUS);

        ObjectAnimator objectAnimator = ObjectAnimator
                .ofFloat(endImageView, "radius", start, end)
                .setDuration(super.getDuration());
        objectAnimator.setInterpolator(super.getInterpolator());
        return objectAnimator;
    }

  public static RadiusTransition toCircle(){
        return new RadiusTransition(0F, 1000F);
    }

    public static  RadiusTransition toSquare() {
        return new RadiusTransition(1000F, 0F);
    }
}
