package com.example.admin.calculater;

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

            // Check if current element is number
            try {
                double element = Double.parseDouble(currentElement);
                stack.push(element);
            } catch (NumberFormatException e) {
                if (!currentElement.equals("")) {
                    number2 = stack.pop();
                    number1 = stack.pop();

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

                    stack.push(interAns);
                }
            }
        }
        interAns = stack.pop();
        result = interAns;
    }

    public double getResult() {
        return result;
    }

}