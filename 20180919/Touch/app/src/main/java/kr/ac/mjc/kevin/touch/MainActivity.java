package kr.ac.mjc.kevin.touch;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView logTv = findViewById(R.id.log_tv);
        LinearLayout touchTarget = findViewById(R.id.touch_target);

        logTv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                logTv.setText("");
                return false;
            }
        });

        mGestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                logTv.append(e.toString());
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                logTv.append(e.toString());
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                logTv.append(e.toString());
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                logTv.append(e1.toString());
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                logTv.append(e.toString());
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                logTv.append(e1.toString());
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(mGestureDetector != null) {
            return mGestureDetector.onTouchEvent(event);
        } else {
            return super.onTouchEvent(event);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this,"가로방향 전환", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"세로방향 전환", Toast.LENGTH_SHORT).show();
        }
    }
}
