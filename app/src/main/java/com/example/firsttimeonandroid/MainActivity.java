package com.example.firsttimeonandroid;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends BaseActivity {

    private static final String PARAM_TO_SAVE = "PARAM_TO_SAVE";
    private static final String DEFAULT_VALUE = "";
    private static final String THEME_LOG = "THEME_LOG";

    private CalculatorData calculatorData;

    protected static final int appThemeStandardCodeStyle = 0;
    protected static final int appThemeDarkCodeStyle = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_main_simple_version);

        boolean theme_log = getIntent().getBooleanExtra(MainActivity.THEME_LOG, false);

        SwitchMaterial switchTheme = findViewById(R.id.switch_theme);
        switchTheme.setChecked(theme_log);

        calculatorData = new CalculatorData(findViewById(R.id.textViewResult), findViewById(R.id.editTextFirstNumber), findViewById(R.id.editTextSecondNumber), findViewById(R.id.switch_theme));

        findViewById(R.id.buttonMinus).setOnClickListener(v -> {
            if (!calculatorData.getFirstNumber().getText().toString().equals("") && !calculatorData.getSecondNumber().getText().toString().equals("")) {
                double firstNum = Integer.parseInt(calculatorData.getFirstNumber().getText().toString());
                double secondNum = Integer.parseInt(calculatorData.getSecondNumber().getText().toString());
                calculatorData.getExpressionResult().setText(String.valueOf(firstNum - secondNum));
            }
        });

        findViewById(R.id.buttonPlus).setOnClickListener(v -> {
            if (!calculatorData.getFirstNumber().getText().toString().equals("") && !calculatorData.getSecondNumber().getText().toString().equals("")) {
                double firstNum = Integer.parseInt(calculatorData.getFirstNumber().getText().toString());
                double secondNum = Integer.parseInt(calculatorData.getSecondNumber().getText().toString());
                calculatorData.getExpressionResult().setText(String.valueOf(firstNum + secondNum));
            }
        });

        findViewById(R.id.buttonX).setOnClickListener(v -> {
            if (!calculatorData.getFirstNumber().getText().toString().equals("") && !calculatorData.getSecondNumber().getText().toString().equals("")) {
                double firstNum = Integer.parseInt(calculatorData.getFirstNumber().getText().toString());
                double secondNum = Integer.parseInt(calculatorData.getSecondNumber().getText().toString());
                calculatorData.getExpressionResult().setText(String.valueOf(firstNum * secondNum));
            }
        });

        findViewById(R.id.buttonDivisionSign).setOnClickListener(v -> {
            if (!calculatorData.getFirstNumber().getText().toString().equals("") && !calculatorData.getSecondNumber().getText().toString().equals("")) {
                double firstNum = Integer.parseInt(calculatorData.getFirstNumber().getText().toString());
                double secondNum = Integer.parseInt(calculatorData.getSecondNumber().getText().toString());
                if (firstNum == 0 || secondNum == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "На ноль делить нельзя.", Toast.LENGTH_SHORT);
                    toast.show();
                    calculatorData.getExpressionResult().setText("На ноль делить нельзя.");
                } else {
                    calculatorData.getExpressionResult().setText(String.valueOf(firstNum / secondNum));
                }
            }
        });

        findViewById(R.id.buttonClear).setOnClickListener(v -> {
            calculatorData.getExpressionResult().setText("");
            calculatorData.getFirstNumber().setText("");
            calculatorData.getSecondNumber().setText("");
        });

        findViewById(R.id.switch_theme).setOnClickListener(v -> {
            if (calculatorData.getSwitchTheme().isChecked()) {
                setAppTheme(appThemeDarkCodeStyle);
            } else {
                setAppTheme(appThemeStandardCodeStyle);
            }
            recreate();
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(PARAM_TO_SAVE, calculatorData.getExpressionResult().getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculatorData.getExpressionResult().setText(savedInstanceState.getString(PARAM_TO_SAVE, DEFAULT_VALUE));
    }
}