package com.laoxu.searchdemo.presenter;

import com.laoxu.searchdemo.contract.IProductContract;
import com.laoxu.searchdemo.model.ProductModel;
import com.laoxu.searchdemo.model.entity.ProductEntity;

public class ProductPresenter implements IProductContract.IPresenter {
    private IProductContract.IView iView;
    private ProductModel productModel;

    public  ProductPresenter(IProductContract.IView iView){
        this.iView = iView;
        productModel = new ProductModel();
    }
    @Override
    public void getProducts(String url) {

        productModel.getProducts(url, new IProductContract.IModel.IModelCallback() {
            @Override
            public void success(ProductEntity productEntity) {
                iView.success(productEntity);
            }

            @Override
            public void error(Throwable throwable) {

                iView.error(throwable);
            }
        });

    }
}
