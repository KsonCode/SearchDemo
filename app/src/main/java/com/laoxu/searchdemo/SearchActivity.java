package com.laoxu.searchdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.laoxu.searchdemo.widget.FlowLayout;
import com.laoxu.searchdemo.widget.SearchLayout;


public class SearchActivity extends AppCompatActivity {

    private SearchLayout searchLayout;
    private FlowLayout flowLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchLayout = findViewById(R.id.layout_search);

        //通过组合控件得到子控件（流式布局）的引用，对象
        flowLayout = searchLayout.findViewById(R.id.layout_flow);


        //初始化
        flowLayout.setFlowLayoutClickListener(new FlowLayout.FlowLayoutClickListener() {
            @Override
            public void clickListener(String s) {

                Toast.makeText(SearchActivity.this, s, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SearchActivity.this,ProductActivity.class);
                intent.putExtra("name",s);
                startActivity(intent);

            }
        });







//        searchLayout.addFlowLayout("inininniin");


    }



}
