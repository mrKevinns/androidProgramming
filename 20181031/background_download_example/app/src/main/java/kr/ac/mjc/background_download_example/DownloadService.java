package kr.ac.mjc.background_download_example;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadService extends Service implements Runnable{

    NotificationManager mNotiManager;
    Notification mNoti;
    Handler handler = new Handler();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread thread = new Thread(this);
        thread.start();
        mNotiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mNoti = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("다운로드 중..")
                    .setContentTitle("다운로드 중..")
                    .setOngoing(true).
                    setProgress(100, 0, false)
                    .build();
            mNotiManager.notify(1, mNoti);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void run() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://github.com/JinYongHwa/AndroidPrograming/blob/master/ch05/test2.txt").build();
        try {
            String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.txt";
            File file = new File(filePath);
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            Response response = client.newCall(request).execute();
            InputStream inputStream = response.body().byteStream();
            byte[] data = new byte[4096];
            long dataLength = response.body().contentLength();
            long downloaded = 0;
            int finalPercent = 0;
            while (true) {
                int length = inputStream.read(data);
                if (length == -1) {
                    break;
                }
                fileOutputStream.write(data, 0, length);
                downloaded += length;
                final int percent = (int) (((double) downloaded / dataLength) * 100);
                if (finalPercent != percent) {
                    finalPercent = percent;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            setProgress(100);
                        }
                    });

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProgress (int percent) {
        if(percent == 100) {
            mNotiManager.cancel(1);
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mNoti = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("다운로드 중..")
                    .setContentTitle("다운로드 중..")
                    .setOngoing(true).
                            setProgress(100, percent, false)
                    .build();
            mNotiManager.notify(1, mNoti);
        }
    }
}
