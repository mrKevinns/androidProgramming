package kr.ac.mjc.myapplication;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.listview);

        ArrayList<ListItem> dataList = new ArrayList<ListItem>();
        for(int i=0; i<100; i++) {
            Drawable drawable;
            if(i%2==0){
                drawable = getResources().getDrawable(R.drawable.image1);
            }
            else {
                drawable = getResources().getDrawable(R.drawable.image2);
            }
            ListItem item = new ListItem(drawable, "제목"+i, "내용"+i, "내용"+i);
            dataList.add(item);
        }
        ListAdapter adapter = new ListAdapter(this, dataList);
        listView.setAdapter(adapter);
    }
}
