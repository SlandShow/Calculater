package com.example.admin.calculater;


import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Pattern;

public class CalculaterActivity extends AppCompatActivity {

    // VARS:
    private TextView screen;
    private String display;
    private String currentOperator;
    private PostfixCalculator calculator;
    private PostfixConverter converter;
    private String displayCopy;


    // INIT ALL VALUES:
    {
        display = "";
        currentOperator = "";
        //converter = new PostfixConverter();
        calculator = new PostfixCalculator();
        displayCopy = "";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculater);

        // Init
        screen = (TextView) findViewById(R.id.textView);
        screen.setText(display);
    }


    private void updateScreen() {
        screen.setText(display);
    }

    ArrayList<String> list = new ArrayList<>();
    String tmpNumber = "";

    // If user push one of the numbers button
    public void onClickNumber(View v) {
        Button b = (Button) v;
        display += b.getText();
        displayCopy += display;
        updateScreen();
        flag = false;
        tmpNumber += b.getText();
    }


    private boolean flag = false;


    // If user push +/-/÷/×
    public void onClickOperator(View v) {
        Button b = (Button) v;
        list.add(tmpNumber);
        tmpNumber = "";

        if (flag) {
            currentOperator = (String) b.getText();
            display = display.substring(0, display.length() - 1) + currentOperator;
            list.set(list.size() - 2, currentOperator);
            updateScreen();
        } else {
            display += b.getText();
            displayCopy += display;
            flag = true;
            list.add((String) b.getText());
            updateScreen();
        }
    }

    // If user push `=` button
    /*
     example:
     2 + 3 - 2 --> 2,3+2-
     1 * 2 + 3 --> 1,2*3+
     (1 + 2) * 3 --> 1,2,+3*
     5 + 9 * 2 --> 5,9,2*+
     */

    public void onClickEqual(View v) {
        list.add(tmpNumber);
        tmpNumber = "";

        String tmp = "";
        for (String element : list) {
            Toast.makeText(getApplicationContext(), element, Toast.LENGTH_SHORT).show();
            tmp += element + " ";
        }
        Toast.makeText(getApplicationContext(), tmp, Toast.LENGTH_SHORT).show();
        display = tmp;

        Log.d("DEB", display);

        // Transform notation to postfix
        converter = new PostfixConverter(tmp);
        // Get this postfix notation
        String postfixNotation = converter.getPostfix();
        display = postfixNotation;
        // Calculate via postfix
        calculator.startCalculate(postfixNotation);
        // Show result on screen
        display = Double.toString(calculator.getResult());
        updateScreen();
    }


    // If user push `C` (clear) button
    public void onClickClear(View v) {
        clear(); // Clear display and operators
    }


    private void clear() {
        display = "";
        currentOperator = "";
        list.clear();
        tmpNumber = "";
        updateScreen();
    }


}



