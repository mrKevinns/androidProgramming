package kr.ac.mjc.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;


public class ListAdapter extends BaseAdapter{

    ArrayList<ListItem> dataList = new ArrayList<ListItem>();
    Context mContext;

    public ListAdapter(Context context, ArrayList<ListItem> list) {
        this.mContext = context;
        this.dataList = list;
    }

    @Override
    public int getCount() {

        return dataList.size();
    }

    @Override
    public ListItem getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemLayout itemView;
        if(convertView == null){
            itemView = new ListItemLayout(mContext);
        }
        else {
            itemView = (ListItemLayout) convertView;
        }
        ListItem listitem = getItem(position);

        itemView.setImage(listitem.getImage());
        itemView.setTitle(listitem.getTitle());
        itemView.setData1(listitem.getData1());
        itemView.setData2(listitem.getData2());

        return itemView;
    }
}
