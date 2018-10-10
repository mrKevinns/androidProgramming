package kr.ac.mjc.hj.broadcastreceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import kr.ac.mjc.hj.broadcastreceive.MainActivity;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
