package kr.ac.mjc.hj.toast_dialog_example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText xOffsetET = findViewById(R.id.xOffset_et);
        final EditText yOffsetET = findViewById(R.id.yOffset_et);
        Button toastBtn = findViewById(R.id.toast_btn);
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int xOffset = Integer.parseInt(xOffsetET.getText().toString());
                int yOffset = Integer.parseInt(yOffsetET.getText().toString());

                Toast t = Toast.makeText(MainActivity.this, "Hello, World!", Toast.LENGTH_SHORT);
                t.setGravity(Gravity.CENTER, xOffset, yOffset);
                t.show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("종료");
        builder.setMessage("정말 종료하시겠습니까?");
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();                       //app을 종료
            }
        });
        builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();               //dialog만 닫음
            }
        });
        builder.show();
    }
}
