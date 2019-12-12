package com.laoxu.searchdemo.view.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.laoxu.searchdemo.MainActivity;
import com.laoxu.searchdemo.R;

public class MyFragment extends Fragment {
    private TextView tv;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_my_layout, null);

        initView(view);
        return view;
    }

    private void initView(View view) {
        tv = view.findViewById(R.id.click);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv,"scaleX",0f,1f);
                ObjectAnimator yAnimator = ObjectAnimator.ofFloat(tv,"scaleY",0f,1f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(objectAnimator).with(yAnimator);

                animatorSet.setDuration(3000);

                animatorSet.start();
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
