package com.laoxu.searchdemo.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.laoxu.searchdemo.R;


/**
 * 搜索控件：组合方式
 */
public class SearchLayout extends LinearLayout {
    public SearchLayout(Context context) {
        super(context);
        init(context);
    }

    public SearchLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SearchLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化方法
     */
    public void init(Context context){
        //渲染布局
        View view = View.inflate(context, R.layout.search_layout,null);
        //把当前布局添加到当前组合控件之上
        addView(view);
    }

}
