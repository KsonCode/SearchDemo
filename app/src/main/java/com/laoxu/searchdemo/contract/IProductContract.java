package com.laoxu.searchdemo.contract;

import com.laoxu.searchdemo.model.entity.ProductEntity;

/**
 * 商品呢列表契约类
 */
public interface IProductContract {

    interface IModel{
        void getProducts(String url,IModelCallback modelCallback);

        interface IModelCallback{
            void success(ProductEntity productEntity);
            void error(Throwable throwable);
        }
    }


    interface IView{

        void success(ProductEntity productEntity);
        void error(Throwable throwable);

    }

    interface  IPresenter{

        void getProducts(String url);

    }
}
