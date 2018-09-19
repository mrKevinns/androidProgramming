package kr.ac.mjc.kevin.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

public class CountService extends Service implements Runnable{

    Handler handler = new Handler();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread t = new Thread(this);
        t.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void run() {
        int i = 0;
        while  (true) {
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==5) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(CountService.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                break;
            }
        }
    }
}
