package com.laoxu.searchdemo.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.laoxu.searchdemo.MainActivity;
import com.laoxu.searchdemo.R;
import com.laoxu.searchdemo.contract.IProductContract;
import com.laoxu.searchdemo.model.entity.ProductEntity;
import com.laoxu.searchdemo.presenter.ProductPresenter;
import com.laoxu.searchdemo.widget.FlowLayout;
import com.laoxu.searchdemo.widget.SearchLayout;

import java.net.URLEncoder;
import java.util.List;

public class SearchFragment extends Fragment implements IProductContract.IView {
    private SearchLayout searchLayout;
    private FlowLayout flowLayout;

    private ProductPresenter presenter;
    private Button searchBtn;


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

        presenter =  new ProductPresenter(this);

        String keyword = "板鞋";//原始中文数据
        //只有经过中文编码，才能请求中文参数的数据
        //经过编码的,不编码无法传递中文
        String encodeKey = URLEncoder.encode(keyword);

        presenter.getProducts("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+encodeKey+"&count=10&page=1");


//        String s = null;
//        System.out.println(s);
    }

    private void initView(View view) {
        searchLayout = view.findViewById(R.id.search_layout);
        flowLayout = searchLayout.findViewById(R.id.layout_flow);


        searchBtn = view.findViewById(R.id.btn_search);

        //5分，接口回调toast
        flowLayout.setFlowLayoutClickListener(new FlowLayout.FlowLayoutClickListener() {
            @Override
            public void clickListener(String s) {
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //经过编码的,不编码无法传递中文
                String encodeKey = URLEncoder.encode("手机");

                presenter.getProducts("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+encodeKey+"&count=10&page=1");


            }
        });

    }

    /**
     * 接口请求成功的方法
     * @param productEntity
     */
    @Override
    public void success(ProductEntity productEntity) {
        //得到商品列表的对象
        List<ProductEntity.Product> list = productEntity.getResult();
        //传值
        flowLayout.addChildsView(list);
    }

    /**
     * 失败
     * @param throwable
     */
    @Override
    public void error(Throwable throwable) {

    }
}
