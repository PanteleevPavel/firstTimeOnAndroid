package com.example.firsttimeonandroid;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String PARAM_TO_SAVE = "PARAM_TO_SAVE";
    public static final String DEFAULT_VALUE = "";

    private CalculatorData calculatorData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_main_simple_version);

        calculatorData = new CalculatorData(findViewById(R.id.textViewResult), findViewById(R.id.editTextFirstNumber), findViewById(R.id.editTextSecondNumber));

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