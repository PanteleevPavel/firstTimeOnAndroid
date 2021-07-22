package com.example.firsttimeonandroid;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class LoginActivity extends BaseActivity {

    private SwitchMaterial switchThemeLog;

    protected static final int appThemeStandardCodeStyle = 0;
    protected static final int appThemeDarkCodeStyle = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        switchThemeLog = findViewById(R.id.switch_theme_log);

        findViewById(R.id.button_run_calc).setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            if (switchThemeLog.isChecked()) {
                setAppTheme(appThemeDarkCodeStyle);
            } else {
                setAppTheme(appThemeStandardCodeStyle);
            }
            intent.putExtra("THEME_LOG", switchThemeLog.isChecked());
            startActivity(intent);
        });
    }
}