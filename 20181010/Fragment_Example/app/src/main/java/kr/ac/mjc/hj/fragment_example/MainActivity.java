package kr.ac.mjc.hj.fragment_example;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setImage(int index) {
        viewerFragment vf = (viewerFragment) getFragmentManager().findFragmentById(R.id.viewer_fragment);
        vf.setIage(index);
    }
}
