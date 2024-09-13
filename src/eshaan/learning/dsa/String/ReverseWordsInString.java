package eshaan.learning.dsa.String;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s);
        Stack<String> stack = new Stack<>();
        while (tokenizer.hasMoreElements()) {
            System.out.println(stack.push(tokenizer.nextToken()));
        }
        return stack.toString();
    }

    public static void main(String [] args){
        ReverseWordsInString r = new ReverseWordsInString();
        String result = r.reverseWords("Hello World");
        System.out.println(result);

    }

}
