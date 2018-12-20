package com.cop.zqc.fragmentmywork;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

public class MyTransition extends Transition {


    private static final String MyTransition_X= "com.cop.zqc.fragmentmywork:MyTransition:X";
    private static final String MyTransition_Y= "com.cop.zqc.fragmentmywork:MyTransition:Y";
    private static final String MyTransition_Width= "com.cop.zqc.fragmentmywork:MyTransition:Width";
    private static final String MyTransition_Height= "com.cop.zqc.fragmentmywork:MyTransition:Width";

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    private void captureValues(TransitionValues transitionValue) {
        // Capture the property values of views for later use
        transitionValue.values.put(MyTransition_X, transitionValue.view.getX());
        transitionValue.values.put(MyTransition_Y, transitionValue.view.getY());
        transitionValue.values.put(MyTransition_Width, transitionValue.view.getWidth());
        transitionValue.values.put(MyTransition_Height, transitionValue.view.getHeight());
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, final TransitionValues startValues, TransitionValues endValues) {

        final View StartView = startValues.view;
        final View EndView = endValues.view;

        int StartViewX = (int)startValues.values.get(MyTransition_X);
        int StartViewY = (int)startValues.values.get(MyTransition_Y);
        int EndViewX = (int)endValues.values.get(MyTransition_X);
        int EndViewY = (int)endValues.values.get(MyTransition_Y);
        int StartViewWidth = (int)endValues.values.get(MyTransition_Width);
        int EndViewWidth = (int)endValues.values.get(MyTransition_Width);


        ValueAnimator StartViewMoveOut = ValueAnimator.ofFloat(StartViewX,StartViewWidth);
        StartViewMoveOut.setDuration(600);
        StartViewMoveOut.setInterpolator(new AccelerateDecelerateInterpolator());
        StartViewMoveOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                StartView.setX((int)animation.getAnimatedValue());

            }
        });


        ValueAnimator EndViewMoveIn = ValueAnimator.ofFloat(EndViewWidth,EndViewX);
        StartViewMoveOut.setDuration(600);
        StartViewMoveOut.setInterpolator(new AccelerateDecelerateInterpolator());
        StartViewMoveOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                EndView.setX((int)animation.getAnimatedValue());

            }
        });

        AnimatorSet animatorSet = new AnimatorSet();

        animatorSet.playSequentially(StartViewMoveOut,EndViewMoveIn);

        return animatorSet;
    }
}
