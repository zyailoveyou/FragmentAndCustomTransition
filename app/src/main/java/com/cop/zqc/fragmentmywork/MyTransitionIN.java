package com.cop.zqc.fragmentmywork;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

public class MyTransitionIN extends Transition {


    private static final String MyTransition_MovingDestenceIN= "com.cop.zqc.fragmentmywork:MyTransitionIN:Width";

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        transitionValues.values.put(MyTransition_MovingDestenceIN,transitionValues.view.getWidth());
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        transitionValues.values.put(MyTransition_MovingDestenceIN,0);
    }



    @Override
    public Animator createAnimator(ViewGroup sceneRoot, final TransitionValues startValues, TransitionValues endValues) {

        if (startValues  == null|| endValues == null)
        {
            return null;
        }

        final View EndView = endValues.view;

        int StartViewMoving = (int)startValues.values.get(MyTransition_MovingDestenceIN);
        int EndViewMoving = (int)endValues.values.get(MyTransition_MovingDestenceIN);


        ValueAnimator StartViewMoveOut = ValueAnimator.ofFloat(EndViewMoving,StartViewMoving);
        StartViewMoveOut.setDuration(600);
        StartViewMoveOut.setInterpolator(new AccelerateDecelerateInterpolator());
        StartViewMoveOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                EndView.setTranslationX((Float) animation.getAnimatedValue());

            }
        });


        ValueAnimator EndViewMoveIn = ValueAnimator.ofFloat(StartViewMoving,EndViewMoving);
        EndViewMoveIn.setDuration(600);
        EndViewMoveIn.setInterpolator(new AccelerateDecelerateInterpolator());
        EndViewMoveIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                EndView.setTranslationX((float)animation.getAnimatedValue());

            }
        });


        AnimatorSet animatorSet = new AnimatorSet();

        animatorSet.playSequentially(StartViewMoveOut,EndViewMoveIn);

        return animatorSet;

    }
}
