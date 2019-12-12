package com.laoxu.searchdemo.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.laoxu.searchdemo.MainActivity;
import com.laoxu.searchdemo.R;
import com.laoxu.searchdemo.widget.FlowLayout;
import com.laoxu.searchdemo.widget.SearchLayout;

public class SearchFragment extends Fragment {
    private SearchLayout searchLayout;
    private FlowLayout flowLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_home_layout,null);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
    }

    private void initView(View view) {
        searchLayout = view.findViewById(R.id.search_layout);
        flowLayout = searchLayout.findViewById(R.id.layout_flow);

        //设置点击事件
        flowLayout.setFlowLayoutClickListener(new FlowLayout.FlowLayoutClickListener() {
            @Override
            public void clickListener(String s) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.gotoFrament(s);
            }
        });
    }
}
