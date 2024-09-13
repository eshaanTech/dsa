package eshaan.learning.dsa;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        //remove all space characters
        s=s.replaceAll("\\s", "");
        Stack<Integer>stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        //iterate thru the string
        for(int i=0; i<s.length(); i++){
            char currentChar = s.charAt(i);
            //if char is digit, handle the multi-digit numbers
            if(Character.isDigit(currentChar)){
                int temp = currentChar-'0';
                currentNumber = currentNumber * 10 + temp;
            }
            //if the character is non-digit or the last character of the string, do following
            if(!Character.isDigit(currentChar) || i == s.length()-1){
                if(operation == '+'){
                    stack.push(currentNumber);
                }else if (operation == '-'){
                    stack.push(-currentNumber);
                }else if(operation == '*'){
                    stack.push(stack.pop()*currentNumber);
                }else if(operation == '/'){
                    stack.push(stack.pop()/currentNumber);
                }
                //reset the operation and current number
                operation = currentChar;
                currentNumber = 0;

            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;

    }
    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        String expression = "3+2*2-4/2";
        BasicCalculator bc = new BasicCalculator();
        int result = bc.calculate(expression);
        System.out.println("Result: " + result);  // Output should be 5
    }
}
