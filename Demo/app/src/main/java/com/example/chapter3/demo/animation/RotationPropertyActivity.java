package com.example.chapter3.demo.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;

import com.example.chapter3.demo.R;

public class RotationPropertyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation_property);
//方式1
        ObjectAnimator animator = ObjectAnimator.ofFloat(findViewById(R.id.image_view),
                "rotation", 0, 360);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(8000);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.start();
//方式2     res/animator/rotate.xml
//        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.rotate);
//        animator.setTarget(findViewById(R.id.image_view));
//        animator.start();

//        final View v = findViewById(R.id.image_view);
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 360);
//        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
//        valueAnimator.setInterpolator(new LinearInterpolator());
//        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
//        valueAnimator.setDuration(8000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                v.setRotation((float) animation.getAnimatedValue());
//            }
//        });
//        valueAnimator.start();
    }

    @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
