package kr.ac.mjc.okhttp_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NewsItemLayout extends LinearLayout {
    Context mContext;
    TextView titleTv;
    TextView desTv;

    public NewsItemLayout(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.item_news, this, true);
        titleTv = findViewById(R.id.title_tv);
        desTv = findViewById(R.id.des_tv);
    }
    public void setTitle(String title) {
        titleTv.setText(title);
    }
    public void setDescription(String description) {
        desTv.setText(description);
    }
}
