package com.example.firsttimeonandroid;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String NameSharedPreference = "LOGIN";

    private static final String AppTheme = "APP_THEME";

    protected static final int AppThemeDarkCodeStyle = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.Theme_FirstTimeOnAndroid));
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    protected int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, codeStyle);
    }

    protected void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        if (codeStyle == AppThemeDarkCodeStyle) {
            return R.style.MyDarkTheme;
        }
        return R.style.Theme_FirstTimeOnAndroid;
    }
}
