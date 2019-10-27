package com.example.myapplicationnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class LoaderAdapter extends RecyclerView.Adapter<LoaderAdapter.MyViewHolder> {

    Context context;
    List<MyNews> myNewsList ;

    public LoaderAdapter(Context context, List<MyNews> myNewsList) {
        this.context = context;
        this.myNewsList = myNewsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.MethodHolder(myNewsList.get(position));

    }

    @Override
    public int getItemCount() {
        return myNewsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView1, textView2,textView3,textView4, textView5,textView6,textView7;
        ImageView imageView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                textView1 = itemView.findViewById(R.id.text1);
                textView2 = itemView.findViewById(R.id.text2);
                textView3 = itemView.findViewById(R.id.text3);
                textView4 = itemView.findViewById(R.id.text4);
                textView5 = itemView.findViewById(R.id.text5);
                textView6 = itemView.findViewById(R.id.text6);
                textView7 = itemView.findViewById(R.id.text7);

                imageView = itemView.findViewById(R.id.image);
            }

        public void MethodHolder(MyNews myNews) {
                textView1.setText((CharSequence) myNews.getSource());
                textView2.setText(myNews.getAuthor());
                textView3.setText(myNews.getTitle());
                textView4.setText(myNews.getDescription());
                textView5.setText(myNews.getPublishedAt());
                textView6.setText(myNews.getContent());
                textView7.setText(myNews.getUrl());

            Picasso.with(context).load(myNews.getUrlToImage()).into(imageView);


        }
    }

}
