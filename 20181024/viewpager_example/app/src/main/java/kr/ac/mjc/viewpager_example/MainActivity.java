package kr.ac.mjc.viewpager_example;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);
        ImagePagesAdapter adapter = new ImagePagesAdapter(this);
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
