package kr.ac.mjc.myapplication;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView versionTv = findViewById(R.id.version_tv);


        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(),0);
            int versionCode = info.versionCode;
            String versionName = info.versionName;
            String msg = String.format("현재 앱의 버전코드는 %d이고, 버전명은 %s입니다.", versionCode, versionName);
            versionTv.setText(msg);
            Log.d("test",msg);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
