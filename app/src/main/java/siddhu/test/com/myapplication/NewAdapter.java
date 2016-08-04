package siddhu.test.com.myapplication;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/*
1- Create an adapter
2- Create viewHolder inside adapter
3- make the adapter of type viewholder
4- create the constructor and the local list
5- implement the 3 methods
6- use glide in onBindViewHolder (add dependency)
7- in MainActivity add a layout mananger for the recycleView
8- set adapter to teh RecycleView
9- add internet permission to the manifest

- Adding handler to card
1- Create Activity
2- Override onCreate
3- Design Layout with WebView
4- Mention in menifest
5- use setcontentview in DetailsActivity
6- add id to cardview
7- update adapter: viewholder
8- add an onclicklistener in onBindViewHolder
9.show toast with position


 */

import siddhu.test.com.myapplication.objects.NewsObjects;

/**
 * Created by admin on 8/4/2016.
 */

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewsViewHolder> {

    List<NewsObjects> newsItems;

    public NewAdapter(List<NewsObjects> newsItems) {
        this.newsItems = newsItems;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_news,parent,false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, final int position) {
        if(newsItems == null)
            return;
        NewsObjects currentNewsObject = newsItems.get(position);
        holder.title.setText(currentNewsObject.getTitle());
        holder.date.setText(currentNewsObject.getDate());
        holder.desc.setText(currentNewsObject.getDescription());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "this is siddh"+position, Toast.LENGTH_SHORT).show();
            }
        });
        Glide.with(holder.newsImage.getContext()).load(currentNewsObject.getImageUrl()).into(holder.newsImage);
    }


    @Override
    public int getItemCount() {
        if(null == newsItems)
        return 0;
        return  newsItems.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView newsImage;
        public TextView title;
        public TextView desc;
        public TextView date;
        public CardView cardView;



        public NewsViewHolder(View itemView) {
            super(itemView);
            newsImage = (ImageView) itemView.findViewById(R.id.item_name_image);
            title = (TextView) itemView.findViewById(R.id.item_name_title);
            desc = (TextView) itemView.findViewById(R.id.item_name_description);
            date = (TextView) itemView.findViewById(R.id.item_name_time);
            cardView = (CardView) itemView.findViewById(R.id.item_news_card);
        }
    }
}
