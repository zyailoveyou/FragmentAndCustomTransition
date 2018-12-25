package com.cop.zqc.fragmentmywork;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

public class MyTransitionOUT extends Transition {

    private static final String MyTransition_MovingDestenceOUT= "com.cop.zqc.fragmentmywork:MyTransitionOUT:Width";

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        transitionValues.values.put(MyTransition_MovingDestenceOUT,0);
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {

        transitionValues.values.put(MyTransition_MovingDestenceOUT,transitionValues.view.getWidth());

    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, final TransitionValues endValues) {

        if (startValues  == null|| endValues == null)
        {
            return null;
        }


        final View EndView = endValues.view;

        int StartViewMoving = (int)startValues.values.get(MyTransition_MovingDestenceOUT);
        int EndViewMoving = (int)endValues.values.get(MyTransition_MovingDestenceOUT);


        ValueAnimator StartViewMoveOut = ValueAnimator.ofFloat(StartViewMoving,EndViewMoving);
        StartViewMoveOut.setDuration(600);
        StartViewMoveOut.setInterpolator(new AccelerateDecelerateInterpolator());
        StartViewMoveOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                EndView.setTranslationX((Float) animation.getAnimatedValue());

            }
        });

        return StartViewMoveOut;
    }
}
