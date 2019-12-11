package com.laoxu.searchdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.laoxu.searchdemo.widget.SearchLayout;


public class SearchActivity extends AppCompatActivity {

    private SearchLayout searchLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchLayout = findViewById(R.id.layout_search);



//        searchLayout.addFlowLayout("inininniin");


    }
}
