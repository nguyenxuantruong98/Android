package com.t3h.miniproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.t3h.miniproject.databinding.ActivityItemBinding;
import com.t3h.miniproject.model.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewHolder> {
    private ArrayList<News> data;
    private LayoutInflater inflater;

    public void setData(ArrayList<News> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public NewsAdapter(Context context) {
       inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.activity_item,parent,false);
        return  new NewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewHolder holder, int position) {
            holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    public class NewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvTitle;
        private TextView tvDesc;
        private TextView tvDate;
        public NewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tvTitle=itemView.findViewById(R.id.tv_title);
            tvDesc=itemView.findViewById(R.id.tv_desc);
            tvDate=itemView.findViewById(R.id.tv_Date);

        }
        public void bindData(News news){
           tvTitle.setText(news.getTitle());
           tvDesc.setText(news.getDesc());
           tvDate.setText(news.getDate());
            Glide.with(img).load(news.getImg()).into(img);

        }
    }
}
