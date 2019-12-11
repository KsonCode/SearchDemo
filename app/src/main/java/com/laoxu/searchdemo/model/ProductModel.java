package com.laoxu.searchdemo.model;

import com.google.gson.Gson;
import com.laoxu.searchdemo.contract.IProductContract;
import com.laoxu.searchdemo.model.entity.ProductEntity;
import com.laoxu.searchdemo.utils.VolleyUtils;

public class ProductModel implements IProductContract.IModel {
    @Override
    public void getProducts(String url, final IModelCallback modelCallback) {

        VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallback() {
            @Override
            public void success(String response) {//返回一个json结果串
//                {"result":[{"commodityId":101,"commodityName":"vivo X23幻彩版 多套餐 全面屏拍照美颜超大广角摄影水滴屏智能4G 正品vivox23手机","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/2/1.jpg","price":2798,"saleNum":0},{"commodityId":112,"commodityName":"黑色重力支架 车载手机架汽车用导航支架车上支撑出风口汽车内多功能通用型金属车载支架","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/6/1.jpg","price":35,"saleNum":0},{"commodityId":109,"commodityName":"新款奢华镶钻镜面iphone xs max手机壳苹果7plusl软边时尚保护套","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/3/1.jpg","price":89,"saleNum":0},{"commodityId":104,"commodityName":"OPPO R17 全网通 8G+128G 美拍补光灯+美容补水仪套餐 全面屏AI智慧美颜双摄拍照手机","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/5/1.jpg","price":3799,"saleNum":0},{"commodityId":119,"commodityName":"斯泰克 吃鸡神器手游键盘 快捷射击辅助按键四指手机游戏 绝地求生刺激战场游戏手柄合金款 苹果安卓通用 扳机射击按键（2件装）","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/yyyl/6/1.jpg","price":39,"saleNum":0},{"commodityId":100,"commodityName":"【壳膜线套餐】 苹果 iPhone XS 256G 全网通手机","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/1/1.jpg","price":10069,"saleNum":0},{"commodityId":111,"commodityName":"三合一充电器数据线苹果二合一拖安卓手机多用功能多头车载苹果安卓一拖三数据线Type-C铝合金编织线 土豪金","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/5/1.jpg","price":39,"saleNum":0},{"commodityId":106,"commodityName":"三星Galaxy S9+ 6GB+128GB版曲屏手机/指纹识别手机/拍照手机","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/7/1.jpg","price":6199,"saleNum":0},{"commodityId":103,"commodityName":"【送自拍杆】魅族 魅蓝 E3 64G 全面屏 全网通手机","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/4/1.jpg","price":1638,"saleNum":0},{"commodityId":114,"commodityName":"羽博 可悬挂无线蓝牙便携音响 布面工艺方形户外超重低音蓝牙音响车载手机迷你蓝牙音箱","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/yyyl/1/1.jpg","price":49,"saleNum":0}],"message":"查询成功","status":"0000"}

                ProductEntity productEntity = new Gson().fromJson(response,ProductEntity.class);

                modelCallback.success(productEntity);
            }

            @Override
            public void failure(Throwable error) {

                modelCallback.error(error);
            }
        });
    }
}
