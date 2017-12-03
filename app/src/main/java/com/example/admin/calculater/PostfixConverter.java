package com.example.admin.calculater;

import java.util.Stack;

/**
 * Created by Admin on 02.12.2017.
 */

class PostfixConverter {

    private Stack<String> stack;
    private String output;
    private String input;

    public PostfixConverter(String input) {
        this.input = input;
        stack = new Stack<>();
        output = "";

        // Convert infix notation to postfix
        convert();
    }

    public PostfixConverter() {
        stack = new Stack<>();
        output = "";
    }

    public void startConvert(String output) {
        this.output = output;
        convert();
    }

    private void gotOperator(String element, int priority) {
        while (!stack.isEmpty()) {
            String opTop = stack.pop();
            int oldPriority = -1;

            if (opTop.equals("+") || opTop.equals("-"))
                oldPriority = 1;
            else oldPriority = 2;

            if (oldPriority < priority) {
                stack.push(opTop + " ");
                break;
            } else output += opTop + " ";
        }
        stack.push(element);
    }

    // From infix to postfix notation
    private void convert() {
        String[] elements = input.split(" ");

        for (String element : elements) {
            if (element.equals("+") || element.equals("-"))
                gotOperator(element, 1);
            else if (element.equals("×") || element.equals("/"))
                gotOperator(element, 2);
            else output += element + " ";
        }

        while (!stack.isEmpty())
            output += stack.pop() + " ";
    }

    public String getPostfix() {
        return output;
    }

}