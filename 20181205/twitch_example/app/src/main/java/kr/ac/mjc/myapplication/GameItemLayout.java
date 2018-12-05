package kr.ac.mjc.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class GameItemLayout extends LinearLayout {
    ImageView imageIv;
    TextView titleTv;
    TextView channelTv;
    TextView viewerTv;


    public GameItemLayout(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_game, this, true);

        imageIv = findViewById(R.id.img_iv);
        titleTv = findViewById(R.id.title_tv);
        channelTv = findViewById(R.id.channel_tv);
        viewerTv = findViewById(R.id.viewer_tv);
    }

    public void setTop(Top top) {
        titleTv.setText(top.getGame().getName());
        channelTv.setText(String.format("채널수 : %d", top.getChannels()));
        viewerTv.setText(String.format("시청자수 : %d", top.getViewers()));
        Glide.with(imageIv).load(top.getGame().getLogo().getSmall()).into(imageIv);
    }
}
