package kr.ac.mjc.config_example;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;

public class SettingFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    SwitchPreference messageAlarm;
    SwitchPreference alarm;
    SwitchPreference vibrator;
    ListPreference alarmSound;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);

        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(getActivity());
        messageAlarm = (SwitchPreference) findPreference("message_alarm");
        alarm = (SwitchPreference) findPreference("alarm");
        vibrator = (SwitchPreference) findPreference("vibrate");
        alarmSound = (ListPreference) findPreference("alarm_sound");
        pref.registerOnSharedPreferenceChangeListener(this);

        boolean messageAlarm = pref.getBoolean("message_alarm",false);
        alarmSound.setSummary(pref.getString("alarm_sound", ""));
        if(!pref.getBoolean("message_alarm", false)){
            alarm.setEnabled(false);
            vibrator.setEnabled(false);
            alarmSound.setEnabled(false);
        }
        else{
            alarm.setEnabled(true);
            vibrator.setEnabled(true);
            alarmSound.setEnabled(true);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(!sharedPreferences.getBoolean("message_alarm", false)) {
            alarm.setEnabled(false);
            vibrator.setEnabled(false);
            alarmSound.setEnabled(false);
        }
        else {
            alarm.setEnabled(true);
            vibrator.setEnabled(true);
            alarmSound.setEnabled(true);
        }

        if(key.equals("alarm_sound")){
            alarmSound.setSummary(sharedPreferences.getString("alarm_sound", ""));
        }
    }
}