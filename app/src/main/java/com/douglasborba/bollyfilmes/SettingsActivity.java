package com.douglasborba.bollyfilmes;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import androidx.annotation.Nullable;

import java.util.prefs.PreferenceChangeListener;

public class SettingsActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        String value = newValue.toString();

        if (preference instanceof ListPreference){
           ListPreference listPreference = (ListPreference) preference;
           int preferenceIndex = listPreference.findIndexOfValue(value);
           if(preferenceIndex >= 0){
               preference.setSummary(listPreference.getEntries()[preferenceIndex]);
           }
        } else {
            preference.setSummary(value);
        }

        return true;
    }
}
