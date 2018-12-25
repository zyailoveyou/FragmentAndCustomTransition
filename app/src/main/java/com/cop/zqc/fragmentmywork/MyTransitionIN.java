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

//    private void captureValues(TransitionValues transitionValue) {
//        // Capture the property values of views for later use
////        transitionValue.values.put(MyTransition_X, transitionValue.view.getX());
////        transitionValue.values.put(MyTransition_Y, transitionValue.view.getY());
//        transitionValue.values.put(MyTransition_Width, transitionValue.view.getWidth());
//        transitionValue.values.put(MyTransition_Height, transitionValue.view.getHeight());
//    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, final TransitionValues startValues, TransitionValues endValues) {

        if (startValues  == null|| endValues == null)
        {
            return null;
        }


        final View EndView = endValues.view;

//        int StartViewX = (int)startValues.values.get(MyTransition_X);
//        int StartViewY = (int)startValues.values.get(MyTransition_Y);
//        int EndViewX = (int)endValues.values.get(MyTransition_X);
//        int EndViewY = (int)endValues.values.get(MyTransition_Y);
        int StartViewMoving = (int)startValues.values.get(MyTransition_MovingDestenceIN);
        int EndViewMoving = (int)endValues.values.get(MyTransition_MovingDestenceIN);


        ValueAnimator StartViewMoveIN = ValueAnimator.ofFloat(StartViewMoving,EndViewMoving);
        StartViewMoveIN.setDuration(600);
        StartViewMoveIN.setInterpolator(new AccelerateDecelerateInterpolator());
        StartViewMoveIN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                EndView.setTranslationX((Float) animation.getAnimatedValue());

            }
        });


//        ValueAnimator EndViewMoveIn = ValueAnimator.ofFloat(StartViewMoving,EndViewMoving);
//        EndViewMoveIn.setDuration(600);
//        EndViewMoveIn.setInterpolator(new AccelerateDecelerateInterpolator());
//        EndViewMoveIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//
//                EndView.setX((float)animation.getAnimatedValue());
//
//            }
//        });

//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playSequentially(StartViewMoveOut,EndViewMoveIn);
//        return animatorSet;

        return StartViewMoveIN;

    }
}
