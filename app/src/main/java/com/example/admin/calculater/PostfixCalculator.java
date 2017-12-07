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

    private Stack<Double> stack;
    private String regular;
    private double result;

    public PostfixCalculator(String regular) {
        this.regular = regular;
        stack = new Stack<>();

        // Parse and calculate
        parse();
    }

    public PostfixCalculator() {
        stack = new Stack<>();
    }

    public void startCalculate(String regular) {
        this.regular = regular;
        parse();
    }

    private void parse() {
        String currentElement = "";
        String[] elements = regular.split(" ");
        double number1, number2, interAns;

        for (int i = 0; i < elements.length; i++) {
            currentElement = elements[i];

            // Check if current element is operator
            if (isOperator(currentElement)) {
                if (stack.size() > 1 && !currentElement.equals("")) {
                    number2 = stack.pop();
                    number1 = stack.pop();

                    // Make calculations
                    if (currentElement.equals("+"))
                        interAns = number1 + number2;
                    else if (currentElement.equals("-"))
                        interAns = number1 - number2;
                    else if (currentElement.equals("×"))
                        interAns = number1 * number2;
                    else if (currentElement.equals("÷"))
                        interAns = number1 / number2;
                    else interAns = 0;

                    stack.push(interAns);
                }
            } else {
                try {
                    double element = Double.parseDouble(currentElement);
                    stack.push(element);
                } catch (NumberFormatException e) {
                        /*TODO Nothing here!*/
                }
            }
        }
        interAns = stack.pop();
        result = interAns;
    }


    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("×") || s.equals("÷");
    }


    public double getResult() {
        return result;
    }

}