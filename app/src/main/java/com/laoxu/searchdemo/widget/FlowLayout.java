package com.laoxu.searchdemo.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.laoxu.searchdemo.R;
import com.laoxu.searchdemo.model.entity.ProductEntity;

import java.util.List;


/**
 * 流式布局
 */
public class FlowLayout extends ViewGroup {



    private int horizontalSize = 30;//水平的间距
    private int verticalSize = 30;//垂直的间距
    private int color;//颜色属性
    private int size;

    public FlowLayout(Context context) {
        super(context);
        init(context,null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    /**
     * 初始化数据
     */
    public void init(Context context,AttributeSet attrs){

        //得到自定义属性的数组，第一个是属性对象attrs，第二个是引用id
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.FlowLayout);

        //得到颜色值,第一个参数得到引用id，第二个默认值
        color = typedArray.getColor(R.styleable.FlowLayout_myTagColor,Color.BLACK);

        //得到大小值

        size = typedArray.getDimensionPixelSize(R.styleable.FlowLayout_myTagSize,16);

        typedArray.recycle();//数组用完，回收一下



    }



    /**
     * 布局
     * @param changed 改变，就是布局发生改变的时候 changed=true
     * @param l left
     * @param t top
     * @param r  right
     * @param b  bottom
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int left =0 ;
        int top = 0;
        int right = 0;
        int bottom = 0;

        int childCount = getChildCount();//获取当前容器的子控件数量
        System.out.println("count===="+childCount);
        //遍历子view
        if (childCount>0){
            for (int i = 0; i < childCount; i++) {
                //获取每个子控件对象
                View childView = getChildAt(i);

                //测量子view,自动测量宽和高
                childView.measure(0,0);
                //可以得到每一个子view的宽和高

                int childWidth = childView.getMeasuredWidth();//测量过的宽度
                int childHeight = childView.getMeasuredHeight();//测量过的高度

                //折行判断
                DisplayMetrics dm = getResources().getDisplayMetrics();
               int screenWidth =  dm.widthPixels;//屏幕宽度

               //计算right，所有的right的宽度
                right = left+childWidth;
                if (right>screenWidth){//折行，另起一行
                    left = 0;//第二行第三行第四行距离左侧距离设置为0
                    right = left+childWidth;//right距离在前几个基础上累加
                    top = bottom+verticalSize;//换行的顶部，是上一行的底部
                }
                //不换行
                bottom = top+childHeight;//底部是每一行顶部+当前控件高度

                //对子view进行布局，left，top，right，bottom
                childView.layout(left,top,right,bottom);

                //左侧距离累加
                left += childWidth+horizontalSize;

            }
        }

    }



    /**
     * 动态添加集合的子view，一次添加多个子view
     * @param
     */
    public void addChildsView(List<ProductEntity.Product> list) {

        if (list!=null&&list.size()>0){
            for (ProductEntity.Product product : list) {
                //动态创建textview，不清楚用户会添加几个子view
                final TextView textView = new TextView(getContext());

                //设置textview内边距
                textView.setPadding(20, 0, 20, 0);
                //设置文本数据
                textView.setText(product.getCommodityName());
                //设置背景
                textView.setBackgroundResource(R.drawable.flowlayout_bg);
                //设置文字颜色
                textView.setTextColor(color);
                //设置文字大小
                textView.setTextSize(size);


                //旋转动画
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,"rotation",0,360);
                objectAnimator.setDuration(1000);
                objectAnimator.start();


                //把子view加到容器
                addView(textView);

                textView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //数据：textView.getText().toString()
                        //第四部，得到数据，通过接口传递出去
                        flowLayoutClickListener.clickListener(textView.getText().toString());
                    }
                });
            }
        }



    }

    //第二步：声明接口
    private FlowLayoutClickListener flowLayoutClickListener;
    //第三步，初始化接口
    public void setFlowLayoutClickListener(FlowLayoutClickListener flowLayoutClickListener) {
        this.flowLayoutClickListener = flowLayoutClickListener;
    }

    /**
     * 第一步：
     * 创建接口类，并通过接口类的方法去传递数据
     */
    public interface FlowLayoutClickListener{
        void clickListener(String s);
    }

}
