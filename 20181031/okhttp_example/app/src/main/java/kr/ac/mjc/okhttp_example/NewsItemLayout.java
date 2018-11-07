package kr.ac.mjc.okhttp_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class NewsItemLayout extends LinearLayout {
    Context mContext;
    TextView titleTv;
    TextView desTv;
    ImageView imageIv;


    public NewsItemLayout(Context context) {
        super(context);
        this.mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.item_news, this, true);
        titleTv = findViewById(R.id.title_tv);
        desTv = findViewById(R.id.des_tv);
        imageIv = rootView.findViewById(R.id.image_iv);
    }
    public void setItem(Item item) {
        titleTv.setText(item.getTitle());
        desTv.setText(item.getDescription());

        if(item.getEnclosure() != null && item.getEnclosure().getUrl() != null) {
            String url = item.getEnclosure().getUrl();
            imageIv.setVisibility(VISIBLE);
            Glide.with(imageIv).load(url).into(imageIv);
        }
        else {
            imageIv.setVisibility(GONE);
            Glide.with(imageIv).clear(imageIv);
        }
    }
}
