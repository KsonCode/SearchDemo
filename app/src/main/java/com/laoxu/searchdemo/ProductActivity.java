package com.laoxu.searchdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.laoxu.searchdemo.adapter.ProductAdapter;
import com.laoxu.searchdemo.contract.IProductContract;
import com.laoxu.searchdemo.model.entity.ProductEntity;
import com.laoxu.searchdemo.presenter.ProductPresenter;

public class ProductActivity extends AppCompatActivity implements IProductContract.IView {

    private ProductPresenter productPresenter;
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initView();
        initData();
    }

    private void initView() {
        rv = findViewById(R.id.rv);
        //第二步必须设置布局管理器（三种），如果不设置，就不会显示任何效果
        rv.setLayoutManager(new LinearLayoutManager(this));//默认垂直的线性布局管理器

    }

    private void initData() {


        productPresenter = new ProductPresenter(this);//




        String s = getIntent().getStringExtra("name");

        String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+s+"&count=10&page=1";
        productPresenter.getProducts(url);



        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();




    }

    /**
     * 成功的回调：去设置adapter数据
     * @param productEntity
     */
    @Override
    public void success(ProductEntity productEntity) {

        ProductAdapter productAdapter = new ProductAdapter(this,productEntity.getResult());
        rv.setAdapter(productAdapter);


    }


    @Override
    public void error(Throwable throwable) {

    }
}
