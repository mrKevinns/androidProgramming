package kr.ac.mjc.okhttp_example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;
import com.stanfy.gsonxml.XmlParserCreator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity implements Callback {                  //OkHttp 예제
    Button requestBtn, toRssBtn;
    EditText urlEt;
    TextView outputTv;
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
        setContentView(R.layout.activity_main);

        requestBtn = findViewById(R.id.request_btn);
        toRssBtn = findViewById(R.id.toRss_btn);
        urlEt = findViewById(R.id.url_et);
        outputTv = findViewById(R.id.output_tv);

        toRssBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });

        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlEt.getText().toString();
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(url).build();
                client.newCall(request).enqueue(MainActivity.this);
            }
        });

    }

    @Override
    public void onFailure(Call call, IOException e) {
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (response.code() ==200) {
            final String html = response.body().string();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    outputTv.setText(html);
                }
            });
        }
    }
}
