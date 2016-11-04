package com.example.admin.calculater;

import java.util.Stack;

/*
 *This class calculate result of all expression
*/
public class Calculate {

    //VARS:
    private Stack<Double> stack;
    private String input;

    //INIT ALL VALUES (BY CONSTRUCTOR):
    public Calculate(String v) {
        input = v;
        stack = new Stack<>();
    }


    public double doParse() {

        char ch = ' '; //ch is empty
        double num1, num2, interAns;

        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            //if we works with figures (10-th notation)
            if (ch >= '0' && ch <= '9') stack.push((double) ch - '0');
            else {
                //if we work with operators
                num2 = stack.pop();
                num1 = stack.pop();
                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '×':
                        interAns = num1 * num2;
                        break;
                    case '÷':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                        break;
                }
                stack.push(interAns);
            }
        }

        interAns = stack.pop(); //final result of all expression

        return interAns;
    }

}