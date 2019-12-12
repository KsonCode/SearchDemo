package com.laoxu.searchdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.laoxu.searchdemo.view.fragment.SearchFragment;
import com.laoxu.searchdemo.view.fragment.MyFragment;

import java.security.cert.PolicyQualifierInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现计算器
 */
public class MainActivity extends AppCompatActivity {



    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private List<Fragment> fragmentList ;
    private SearchFragment searchFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();


    }

    protected void initData() {
        fragmentList = new ArrayList<>();

        searchFragment = new SearchFragment();
        myFragment = new MyFragment();
        fragmentList.add(searchFragment);
        fragmentList.add(myFragment);

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
                    case  R.id.radio_my:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });

    }


    /**
     * 跳转到第二个fragment
     */
    public void gotoFrament(String s){


        viewPager.setCurrentItem(1);

        Bundle args = new Bundle();
        args.putString("keyword", s);
        myFragment.setArguments(args);

    }


}
