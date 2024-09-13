package eshaan.learning.dsa;

public class ValidParanthesis {
    public String minRemoveToMakeValid(String s) {
        //create StringBuffer
        StringBuilder result = new StringBuilder();
        int balance = 0;
        //remove all invalid closing paranthesis
        for(char c : s.toCharArray()){
            if(c == '('){
                balance++;
            }else if(c == ')'){
                if(balance == 0){
                    continue;
                }
                balance--;
            }
            result.append(c);
        }
        //remove all invalid opening balance
        StringBuilder finalResult = new StringBuilder();
        balance = 0;
        for(int i = result.length()-1; i>=0; i--){
            char c = result.charAt(i);
            if(c == ')'){
                balance++;
            }else if(c == '('){
                if(balance == 0) {
                    continue;
                }
                balance--;
            }
            finalResult.append(c);
        }
        return finalResult.reverse().toString();
    }
    public static void main(String [] args){
        ValidParanthesis vp = new ValidParanthesis();
        System.out.println(vp.minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}
