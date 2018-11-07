package kr.ac.mjc.okhttp_example;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;
import com.stanfy.gsonxml.XmlParserCreator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SecondActivity extends Activity implements Callback {                   //RSS 예제
    Button requestBtn, toHttpBnt;
    EditText urlEt;
    ListView listView;

    ArrayList<Item> mNewsList = new ArrayList<Item>();
    NewsAdapter adapter;


    Handler handler = new Handler();

    XmlParserCreator parserCreator = new XmlParserCreator() {
        @Override
        public XmlPullParser createParser() {
            try {
                return XmlPullParserFactory.newInstance().newPullParser();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        requestBtn = findViewById(R.id.request_btn);
        toHttpBnt = findViewById(R.id.toHttp_bnt);
        urlEt = findViewById(R.id.url_et);

        listView = findViewById(R.id.listView);
        adapter = new NewsAdapter(this, mNewsList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = adapter.getItem(position);
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLink()));
                intent.putExtra("url", item.getLink());
                startActivity(intent);
            }
        });

        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("https://news.sbs.co.kr/news/SectionRssFeed.do?sectionId=02&plink=RSSREADER").build(); //xml parsing 예제
                client.newCall(request).enqueue(SecondActivity.this);
            }
        });

        toHttpBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onFailure(Call call, IOException e) {
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (response.code() ==200) {
            final String xml = response.body().string();
            GsonXml gsonXml = new GsonXmlBuilder().setXmlParserCreator(parserCreator).setSameNameLists(true).create();
            Rss rss = gsonXml.fromXml(xml, Rss.class);
            mNewsList.clear();
            if (rss.channel.item != null) {
                mNewsList.addAll(rss.channel.item);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }
    }
}


