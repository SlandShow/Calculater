package com.example.admin.calculater;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Admin on 02.12.2017.
 */

class PostfixCalculator {

    private Stack<String> stack;
    private String regular;
    private double result;

    public PostfixCalculator(String regular) {
        this.regular = regular;
        stack = new Stack<>();

        // Parse and calculate
        parse(regular);
    }

    public PostfixCalculator() {
        stack = new Stack<>();
    }

    public void startCalculate(String regular) {
        this.regular = regular;
        parse(regular);
    }

    private void parse(String s) {
        String currentElement = "";
        String[] elements = s.split(" ");
        double number1, number2, interAns = 0;

        for (int i = 0; i < elements.length; i++) {
            currentElement = elements[i];

           
            // Check if current element is number
            try {
                double element = Double.parseDouble(currentElement);
                stack.push(String.valueOf(element));
            } catch (NumberFormatException e) {
                if (!currentElement.equals("") ) {
                    try {
                        number2 = Double.valueOf(stack.pop());
                        number1 = Double.valueOf(stack.pop());
                        Log.d("DEB-A", number1 + " " + number2 + " size is " + stack.size());


                        // Make calculations
                        if (currentElement.equals("+"))
                            interAns = number1 + number2;
                        else if (currentElement.equals("-"))
                            interAns = number1 - number2;
                        else if (currentElement.equals("×"))
                            interAns = number1 * number2;
                        else if (currentElement.equals("/"))
                            interAns = number1 / number2;
                        else interAns = 0;

                        stack.push(String.valueOf(interAns));
                    } catch (Exception e1) { /* Fix bug */ }
                }
            }
            Log.d("DEB-A", "interAns:" + interAns);
        }
        interAns = Double.valueOf(stack.pop());
        result = interAns;
    }


    public double getResult() {
        return result;
    }

}