package com.example.firsttimeonandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CalcHardVersion extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_main);

        TextView textViewExpression = findViewById(R.id.text_view_expression);
        TextView textViewPreIndicationResult = findViewById(R.id.text_view_pre_indication_result);
        TextView textViewHistory = findViewById(R.id.text_view_history);
        AtomicReference<Character> lastChar = new AtomicReference<>((char) 0);
        AtomicBoolean stringIsEmpty = new AtomicBoolean(true);
        AtomicInteger parenthesesCount = new AtomicInteger();

        findViewById(R.id.button_parentheses).setOnClickListener(v -> {
            if (parenthesesCount.get() == 0 && lastChar.get() == ')' ||
                    lastChar.get() == '0' && parenthesesCount.get() == 0 ||
                    lastChar.get() == '1' && parenthesesCount.get() == 0 ||
                    lastChar.get() == '2' && parenthesesCount.get() == 0 ||
                    lastChar.get() == '3' && parenthesesCount.get() == 0 ||
                    lastChar.get() == '4' && parenthesesCount.get() == 0 ||
                    lastChar.get() == '5' && parenthesesCount.get() == 0 ||
                    lastChar.get() == '6' && parenthesesCount.get() == 0 ||
                    lastChar.get() == '7' && parenthesesCount.get() == 0 ||
                    lastChar.get() == '8' && parenthesesCount.get() == 0 ||
                    lastChar.get() == '9' && parenthesesCount.get() == 0) {
                textViewExpression.setText(textViewExpression.getText() + "*(");
                parenthesesCount.getAndIncrement();
                lastChar.set('(');
            } else if (parenthesesCount.get() != 0 &&
                    lastChar.get() != '(' &&
                    lastChar.get() != '+' &&
                    lastChar.get() != '-' &&
                    lastChar.get() != '*' &&
                    lastChar.get() != '/') {
                textViewExpression.setText(textViewExpression.getText() + ")");
                parenthesesCount.getAndDecrement();
                lastChar.set(')');
            } else {
                textViewExpression.setText(textViewExpression.getText() + "(");
                parenthesesCount.getAndIncrement();
                lastChar.set('(');
            }
        });

        findViewById(R.id.button_set_minus).setOnClickListener(v -> {
            if (stringIsEmpty.get()) {
                textViewExpression.setText("(-");
                parenthesesCount.getAndIncrement();
                stringIsEmpty.set(false);
                lastChar.set('-');
            } else if (textViewExpression.getText().toString().length() == 1) {
                textViewExpression.setText("(-" + lastChar.get());
                parenthesesCount.getAndIncrement();
            } else if ((lastChar.get() == '0' ||
                    lastChar.get() == '1' ||
                    lastChar.get() == '2' ||
                    lastChar.get() == '3' ||
                    lastChar.get() == '4' ||
                    lastChar.get() == '5' ||
                    lastChar.get() == '6' ||
                    lastChar.get() == '7' ||
                    lastChar.get() == '8' ||
                    lastChar.get() == '9') && (
                    textViewExpression.getText().toString().charAt(textViewExpression.getText().toString().length() - 2) == '+' ||
                            textViewExpression.getText().toString().charAt(textViewExpression.getText().toString().length() - 2) == '*' ||
                            textViewExpression.getText().toString().charAt(textViewExpression.getText().toString().length() - 2) == '/')
            ) {
                textViewExpression.setText(textViewExpression.getText().toString().substring(0, textViewExpression.getText().length() - 1) + "(-" + lastChar.get());
                parenthesesCount.getAndIncrement();
            } else if ((lastChar.get() == '0' ||
                    lastChar.get() == '1' ||
                    lastChar.get() == '2' ||
                    lastChar.get() == '3' ||
                    lastChar.get() == '4' ||
                    lastChar.get() == '5' ||
                    lastChar.get() == '6' ||
                    lastChar.get() == '7' ||
                    lastChar.get() == '8' ||
                    lastChar.get() == '9') &&
                    textViewExpression.getText().toString().charAt(textViewExpression.getText().toString().length() - 2) != '+' &&
                    textViewExpression.getText().toString().charAt(textViewExpression.getText().toString().length() - 2) != '*' &&
                    textViewExpression.getText().toString().charAt(textViewExpression.getText().toString().length() - 2) != '/' &&
                    textViewExpression.getText().toString().charAt(textViewExpression.getText().toString().length() - 2) != '-') {
                textViewExpression.setText(textViewExpression.getText().toString().substring(0, textViewExpression.getText().length() - 1) + "-" + lastChar.get());
            } else if (textViewExpression.getText().toString().charAt(textViewExpression.getText().toString().length() - 2) == '-') {
                textViewExpression.setText(textViewExpression.getText().toString().substring(0, textViewExpression.getText().length() - 2) + lastChar.get());
            }
        });

        findViewById(R.id.button_clear).setOnClickListener(v -> {
            textViewExpression.setText("");
            stringIsEmpty.set(true);
            lastChar.set('(');
            parenthesesCount.set(0);
        });

        findViewById(R.id.button_backspace).setOnClickListener(v -> {
            if (textViewExpression.getText().toString().length() > 0) {
                if (lastChar.get() == '(') {
                    parenthesesCount.getAndDecrement();
                } else if (lastChar.get() == ')') {
                    parenthesesCount.getAndIncrement();
                }
                textViewExpression.setText(textViewExpression.getText().toString().substring(0, textViewExpression.getText().length() - 1));
                if (textViewExpression.getText().toString().length() > 0) {
                    lastChar.set(textViewExpression.getText().toString().charAt(textViewExpression.getText().length() - 1));
                } else {
                    stringIsEmpty.set(true);
                    lastChar.set('(');
                    parenthesesCount.set(0);
                }
            }
        });

        findViewById(R.id.button_0).setOnClickListener(v -> {
            if (lastChar.get() == ')') {
                textViewExpression.setText(textViewExpression.getText() + "*0");
            } else {
                textViewExpression.setText(textViewExpression.getText() + "0");
                stringIsEmpty.set(false);
            }
            lastChar.set('0');
        });

        findViewById(R.id.button_1).setOnClickListener(v -> {
            if (lastChar.get() == ')') {
                textViewExpression.setText(textViewExpression.getText() + "*1");
            } else {
                textViewExpression.setText(textViewExpression.getText() + "1");
                stringIsEmpty.set(false);
            }
            lastChar.set('1');
        });

        findViewById(R.id.button_2).setOnClickListener(v -> {
            if (lastChar.get() == ')') {
                textViewExpression.setText(textViewExpression.getText() + "*2");
            } else {
                textViewExpression.setText(textViewExpression.getText() + "2");
                stringIsEmpty.set(false);
            }
            lastChar.set('2');
        });

        findViewById(R.id.button_3).setOnClickListener(v -> {
            if (lastChar.get() == ')') {
                textViewExpression.setText(textViewExpression.getText() + "*3");
            } else {
                textViewExpression.setText(textViewExpression.getText() + "3");
                stringIsEmpty.set(false);
            }
            lastChar.set('3');
        });

        findViewById(R.id.button_4).setOnClickListener(v -> {
            if (lastChar.get() == ')') {
                textViewExpression.setText(textViewExpression.getText() + "*4");
            } else {
                textViewExpression.setText(textViewExpression.getText() + "4");
                stringIsEmpty.set(false);
            }
            lastChar.set('4');
        });

        findViewById(R.id.button_5).setOnClickListener(v -> {
            if (lastChar.get() == ')') {
                textViewExpression.setText(textViewExpression.getText() + "*5");
            } else {
                textViewExpression.setText(textViewExpression.getText() + "5");
                stringIsEmpty.set(false);
            }
            lastChar.set('5');
        });

        findViewById(R.id.button_6).setOnClickListener(v -> {
            if (lastChar.get() == ')') {
                textViewExpression.setText(textViewExpression.getText() + "*6");
            } else {
                textViewExpression.setText(textViewExpression.getText() + "6");
                stringIsEmpty.set(false);
            }
            lastChar.set('6');
        });

        findViewById(R.id.button_7).setOnClickListener(v -> {
            if (lastChar.get() == ')') {
                textViewExpression.setText(textViewExpression.getText() + "*7");
            } else {
                textViewExpression.setText(textViewExpression.getText() + "7");
                stringIsEmpty.set(false);
            }
            lastChar.set('7');
        });

        findViewById(R.id.button_8).setOnClickListener(v -> {
            if (lastChar.get() == ')') {
                textViewExpression.setText(textViewExpression.getText() + "*8");
            } else {
                textViewExpression.setText(textViewExpression.getText() + "8");
                stringIsEmpty.set(false);
            }
            lastChar.set('8');
        });

        findViewById(R.id.button_9).setOnClickListener(v -> {
            if (lastChar.get() == ')') {
                textViewExpression.setText(textViewExpression.getText() + "*9");
            } else {
                textViewExpression.setText(textViewExpression.getText() + "9");
                stringIsEmpty.set(false);
            }
            lastChar.set('9');
        });

        findViewById(R.id.button_plus).setOnClickListener(v -> {
            if (!stringIsEmpty.get() && (
                    lastChar.get() == '-' ||
                            lastChar.get() == '*' ||
                            lastChar.get() == '/' ||
                            lastChar.get() == '.')) {
                textViewExpression.setText(textViewExpression.getText().toString().substring(0, textViewExpression.getText().length() - 1) + "+");
                lastChar.set('+');
            } else if (lastChar.get() != '+' &&
                    lastChar.get() != '-' &&
                    lastChar.get() != '*' &&
                    lastChar.get() != '/' &&
                    lastChar.get() != '.' &&
                    !stringIsEmpty.get()) {
                textViewExpression.setText(textViewExpression.getText() + "+");
                lastChar.set('+');
            }
        });

        findViewById(R.id.button_minus).setOnClickListener(v -> {
            if (!stringIsEmpty.get() && (
                    lastChar.get() == '+' ||
                            lastChar.get() == '*' ||
                            lastChar.get() == '/' ||
                            lastChar.get() == '.')) {
                textViewExpression.setText(textViewExpression.getText().toString().substring(0, textViewExpression.getText().length() - 1) + "-");
                lastChar.set('-');
            } else if (lastChar.get() != '+' &&
                    lastChar.get() != '-' &&
                    lastChar.get() != '*' &&
                    lastChar.get() != '/' &&
                    lastChar.get() != '.' &&
                    !stringIsEmpty.get()) {
                textViewExpression.setText(textViewExpression.getText() + "-");
                lastChar.set('-');
            }
        });

        findViewById(R.id.button_x).setOnClickListener(v -> {
            if (!stringIsEmpty.get() && (
                    lastChar.get() == '-' ||
                            lastChar.get() == '+' ||
                            lastChar.get() == '/' ||
                            lastChar.get() == '.')) {
                textViewExpression.setText(textViewExpression.getText().toString().substring(0, textViewExpression.getText().length() - 1) + "*");
                lastChar.set('*');
            } else if (lastChar.get() != '+' &&
                    lastChar.get() != '-' &&
                    lastChar.get() != '*' &&
                    lastChar.get() != '/' &&
                    lastChar.get() != '.' &&
                    !stringIsEmpty.get()) {
                textViewExpression.setText(textViewExpression.getText() + "*");
                lastChar.set('*');
            }
        });

        findViewById(R.id.button_division_sign).setOnClickListener(v -> {
            if (!stringIsEmpty.get() && (
                    lastChar.get() == '-' ||
                            lastChar.get() == '*' ||
                            lastChar.get() == '+' ||
                            lastChar.get() == '.')) {
                textViewExpression.setText(textViewExpression.getText().toString().substring(0, textViewExpression.getText().length() - 1) + "/");
                lastChar.set('/');
            } else if (lastChar.get() != '+' &&
                    lastChar.get() != '-' &&
                    lastChar.get() != '*' &&
                    lastChar.get() != '/' &&
                    lastChar.get() != '.' &&
                    !stringIsEmpty.get()) {
                textViewExpression.setText(textViewExpression.getText() + "/");
                lastChar.set('/');
            }
        });

        findViewById(R.id.button_dot).setOnClickListener(v -> {
            if (!stringIsEmpty.get() && (
                    lastChar.get() == '-' ||
                            lastChar.get() == '*' ||
                            lastChar.get() == '/' ||
                            lastChar.get() == '+')) {
                textViewExpression.setText(textViewExpression.getText().toString().substring(0, textViewExpression.getText().length() - 1) + ".");
                lastChar.set('.');
            } else if (lastChar.get() != '+' &&
                    lastChar.get() != '-' &&
                    lastChar.get() != '*' &&
                    lastChar.get() != '/' &&
                    lastChar.get() != '.' &&
                    !stringIsEmpty.get()) {
                textViewExpression.setText(textViewExpression.getText() + ".");
                lastChar.set('.');
            }
        });

        findViewById(R.id.button_result).setOnClickListener(v -> {

        });
    }
}
