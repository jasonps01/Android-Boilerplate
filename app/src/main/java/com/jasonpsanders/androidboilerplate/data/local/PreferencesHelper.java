package com.jasonpsanders.androidboilerplate.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.jasonpsanders.androidboilerplate.injection.ApplicationContext;

import javax.inject.Inject;

public class PreferencesHelper {

    public static final String PREF_FILE_NAME = "android_boilerplate_pref_file";

    private final SharedPreferences mPref;

    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void clear() {
        mPref.edit().clear().apply();
    }
}
