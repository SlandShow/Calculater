package com.example.admin.calculater;


import java.util.Stack;

public class ReversePolishNotationApp {

    //VARS:
    Stack<Character> stack;
    String line;
    String output;



    //INIT:
    { stack = new Stack<Character>();
        line = "";
        output = "";
    }


    //преобразует инфиксную запись в постфиксную
    public void transform(String line) {
        this.line = line; //получаем инфиксную запись
        String[] arrayOfLines = line.split(""); //"\\s+" - это один и более пробел
        int size = line.length();

        for(int i = 0; i < size; i++) {
            char el = line.charAt(i);

            switch (el) {
                case '+':
                case '-':
                    gotOper(el,1);
                    break;
                case '×':
                case '÷':
                    gotOper(el,2);
                    break;
                case '(':
                    stack.push(el);
                    break;
                case ')':
                    gotParen(el);
                    break;
                default:
                    output = output + el;
                    break;

            }
        }

        while (!stack.isEmpty()) output += stack.pop();

    }

    private void gotOper(char currentOp, int priority) {

        while (!stack.isEmpty()) {
            char opTop = stack.pop();
            if(opTop == '(') { stack.push(opTop); break; }
            else {
                int oldPriority = -1;
                if(opTop == '+' || opTop == '-') oldPriority = 1;
                else oldPriority = 2;

                if(oldPriority < priority) { stack.push(opTop); break; }
                else output = output + opTop;
            }
        }
        stack.push(currentOp);
    }





    private void gotParen(char el1) {

        while (!stack.isEmpty()) {
            char elx = stack.pop();
            if(elx == '(') break;
            else output = output + elx;
        }
    }


    public void show() {
        System.out.println(output);
    }

    public String getNewNotation() {
        return output;
    }



}