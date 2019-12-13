package com.laoxu.searchdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.laoxu.searchdemo.view.fragment.SearchFragment;
import com.laoxu.searchdemo.view.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现计算器
 */
public class MainActivity extends AppCompatActivity {



    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private List<Fragment> fragmentList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();


    }

    protected void initData() {
        fragmentList = new ArrayList<>();

        fragmentList.add(new SearchFragment());
        fragmentList.add(new OtherFragment());
        fragmentList.add(new OtherFragment());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });



    }


    protected void initView() {

        viewPager = findViewById(R.id.viewpager);
        radioGroup = findViewById(R.id.radiogroup);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(position);
                radioButton.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case  R.id.radio_bj:
                        viewPager.setCurrentItem(1);
                        break;
                        case  R.id.radio_my:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });

    }




}
