package com.laoxu.searchdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.laoxu.searchdemo.R;
import com.laoxu.searchdemo.model.entity.ProductEntity;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private Context context;
    private List<ProductEntity.Product> list;

    public ProductAdapter(Context context, List<ProductEntity.Product> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * 创建viewwholder实例对象
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.product_item_layout,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    /**
     * 绑定viewholder，绑定数据,负责数据显示的
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        Glide.with(context).load(list.get(position).getMasterPic()).into(holder.iv);
        holder.tv.setText(list.get(position).getCommodityName());

//        //获取条目
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, list.get(position).getCommodityName(), Toast.LENGTH_SHORT).show();
//            }
//        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (itemClickListener!=null){
                    itemClickListener.itemClickListener(list.get(position).getCommodityName());
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        //声明控件
        private ImageView iv;
        private TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //初始化
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.name);
        }
    }

    //第二步声明
    private ItemClickListener itemClickListener;

    //第三步：提供public set方法，提供给接收方初始化接口对象
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    //第一步：创建接口类
    public interface ItemClickListener{
        //参数是商品标题
        void itemClickListener(String name);
    }

}
