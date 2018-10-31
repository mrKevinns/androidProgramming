package kr.ac.mjc.okhttp_example;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class NewsAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Item> mNewsList = new ArrayList<Item>();

    public NewsAdapter(Context context, ArrayList<Item> newsList) {
        this.mContext = context;
        this.mNewsList = newsList;
    }

    @Override
    public int getCount() {
        return mNewsList.size();
    }

    @Override
    public Item getItem(int position) {
        return mNewsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsItemLayout newsItemLayout;

        if(convertView == null) {
            newsItemLayout = new NewsItemLayout(mContext);
        }
        else {
            newsItemLayout = (NewsItemLayout) convertView;
        }
        Item item = getItem(position);
        newsItemLayout.setTitle(item.getTitle());
        newsItemLayout.setDescription(item.getDescription());

        return newsItemLayout;
    }
}
