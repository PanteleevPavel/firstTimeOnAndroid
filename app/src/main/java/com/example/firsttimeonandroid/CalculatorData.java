package com.example.firsttimeonandroid;

import android.widget.TextView;

public class CalculatorData {

    TextView expressionResult;
    TextView firstNumber;
    TextView secondNumber;

    public CalculatorData(TextView expressionResult, TextView firstNumber, TextView secondNumber) {
        this.expressionResult = expressionResult;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
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
}
