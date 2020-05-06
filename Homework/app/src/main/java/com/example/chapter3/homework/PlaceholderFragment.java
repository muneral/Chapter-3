package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView lottie;
    private LinearLayout list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        //return inflater.inflate(R.layout.fragment_placeholder, container, false);
        View fragment = inflater.inflate(R.layout.fragment_placeholder, container, false);
        lottie = fragment.findViewById(R.id.fragment_loading);
        lottie.playAnimation();
        list = fragment.findViewById(R.id.list_item);
        list.setAlpha(0f);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(lottie,
                        "alpha",1.0f,0.0f);
                animator1.setDuration(1000);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(list,
                        "alpha",0.0f,1.0f);
                animator2.setDuration(1000);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(animator1,animator2);
                animatorSet.start();

                lottie.pauseAnimation();

            }
        }, 5000);
    }
}
