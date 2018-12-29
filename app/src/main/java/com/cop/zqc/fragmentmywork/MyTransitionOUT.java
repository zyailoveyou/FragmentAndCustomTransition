package com.cop.zqc.fragmentmywork;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyTransitionOUT extends Transition {

    private static final String MyTransition_MovingDestenceOUT= "com.cop.zqc.fragmentmywork:MyTransitionOUT:Width";
    private static final String MyTransition_BackGroud= "com.cop.zqc.fragmentmywork:MyTransitionOUT:BackGroud_Color";
    private static final String MyTransition_TexT= "com.cop.zqc.fragmentmywork:MyTransitionOUT:Text";

    @Override
    public void captureStartValues(TransitionValues transitionValues) {



            transitionValues.values.put(MyTransition_MovingDestenceOUT,0);
            transitionValues.values.put(MyTransition_BackGroud,transitionValues.view.getBackground());
            if(transitionValues.view instanceof TextView)
            {
            transitionValues.values.put(MyTransition_TexT,((String) ((TextView)transitionValues.view).getText()));

        }
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {



            transitionValues.values.put(MyTransition_MovingDestenceOUT,transitionValues.view.getWidth());
            transitionValues.values.put(MyTransition_BackGroud,transitionValues.view.getBackground());
        if(transitionValues.view instanceof TextView)
        {
            transitionValues.values.put(MyTransition_TexT,((TextView) transitionValues.view).getText());
        }

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

        final Drawable StartColor = (Drawable) startValues.values.get(MyTransition_BackGroud);
        final Drawable EndColor = (Drawable) endValues.values.get(MyTransition_BackGroud);

        final String StartText = (String) startValues.values.get(MyTransition_TexT);
        final String EndText = (String) endValues.values.get(MyTransition_TexT);

        ValueAnimator StartViewMoveOut = ValueAnimator.ofFloat(StartViewMoving,EndViewMoving);
        StartViewMoveOut.setDuration(600);
        StartViewMoveOut.setInterpolator(new AccelerateDecelerateInterpolator());
        StartViewMoveOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                EndView.setTranslationX((Float) animation.getAnimatedValue());
                if(EndView instanceof TextView) {
                    EndView.setBackground(StartColor);
                    ((TextView) EndView).setText(StartText);
                }
            }
        });

        ValueAnimator StartViewMoveIn = ValueAnimator.ofFloat(EndViewMoving,StartViewMoving);
        StartViewMoveIn.setDuration(600);
        StartViewMoveIn.setInterpolator(new AccelerateDecelerateInterpolator());
        StartViewMoveIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                EndView.setTranslationX((Float) animation.getAnimatedValue());
                if(EndView instanceof TextView) {
                    EndView.setBackground(EndColor);
                    ((TextView) EndView).setText(EndText);
                }

            }
        });


        AnimatorSet animatorSet = new AnimatorSet();

        animatorSet.playSequentially(StartViewMoveOut,StartViewMoveIn);

        return animatorSet;
    }


}
