package kr.ac.mjc.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListItemLayout extends LinearLayout {

    private ImageView iamgeView;
    private TextView titleTv;
    private TextView data1Tv;
    private TextView data2Tv;

    public ListItemLayout(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.list_item, this, true);
        iamgeView = rootView.findViewById(R.id.imageview);
        titleTv = rootView.findViewById(R.id.title_tv);
        data1Tv = rootView.findViewById(R.id.data1_tv);
        data2Tv = rootView.findViewById(R.id.data2_tv);
    }

    public void setImage(Drawable img) {
        iamgeView.setImageDrawable(img);
    }
    public void setTitle(String text) {
        titleTv.setText(text);
    }
    public void setData1(String text) {
        data1Tv.setText(text);
    }
    public void setData2(String text) {
        data2Tv.setText(text);
    }
}
