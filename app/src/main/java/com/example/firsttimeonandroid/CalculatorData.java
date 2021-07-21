package com.example.firsttimeonandroid;

import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class CalculatorData {

    private final TextView expressionResult;
    private final TextView firstNumber;
    private final TextView secondNumber;
    private final SwitchMaterial switchTheme;

    public CalculatorData(TextView expressionResult, TextView firstNumber, TextView secondNumber, SwitchMaterial switchTheme) {
        this.expressionResult = expressionResult;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.switchTheme = switchTheme;
    }

    public TextView getExpressionResult() {
        return expressionResult;
    }

    public TextView getFirstNumber() {
        return firstNumber;
    }

    public TextView getSecondNumber() {
        return secondNumber;
    }

    public SwitchMaterial getSwitchTheme() {
        return switchTheme;
    }
}
