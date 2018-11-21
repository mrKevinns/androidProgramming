package kr.ac.mjc.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;

public class SettingFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    SwitchPreference messageAlarm;
    SwitchPreference sound;
    ListPreference alarmSound;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);

        messageAlarm= (SwitchPreference) findPreference(key:"message_alarm");
        sound= (SwitchPreference) findPreference(key:"sound");
        alarmSound= (ListPreference) findPreference(key:"alarm_sound");
        PreferenceManager.getDefaultSharedPreferences(getActivity() );
    }
}

public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    if(key.equlas("message_alarm")){
        boolean messageAlarm=sharedPreferences.getBoolean(key)
    }
}