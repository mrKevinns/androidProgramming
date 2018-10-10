package kr.ac.mjc.hj.broadcastreceive;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int status = checkSelfPermission(Manifest.permission.RECEIVE_SMS);
            if(status == PackageManager.PERMISSION_GRANTED) {   //PERMISSION_GRANTED의 값은 0

            }
            else {
                requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS}, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "SMS 권한 요청이 승인되었습니다.", Toast.LENGTH_SHORT).show(); //LENGTH>SHORT의 값은 0

            }
        }
    }
}
