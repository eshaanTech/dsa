package eshaan.learning.dsa.String;

public class ATOIConverStringToNumber {
    public int myAtoi(String s) {
        //cleanup spaces
        //ensure the string is not empty, if it is, we will return
        //we will initialize few variable - total, sign index to iterate over the string and result
        s = s.trim();
        if(s.isEmpty())
            return -0;
        //initialize variables
        int result;
        int index=0;
        int n = s.length();
        int total = 0;//keep track of the total
        int sign = 1;//setting it to by default which represents the positive integer, we will flip if we see "_" later
        if(s.charAt(index)=='-' || s.charAt(index)=='+'){
            sign=(s.charAt(index)=='-')?-1:1;
            index++;
        }
        //iterate thru the string
        while(index<n){
            //chech if it is sign
            char currentChar = s.charAt(index);
            //if non-digit chars, break
            if(!Character.isDigit(currentChar))
                    break;
            //convert the char to int
            int digit = currentChar - '0';
            //check overflow/underflow
            if(total > (Integer.MAX_VALUE-digit)/10){
                return (sign == 1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }

            //add to total
            total = total*10+digit;
            index++;
        }
        return total * sign;


    }

    public static void main (String[] args){
        ATOIConverStringToNumber as = new ATOIConverStringToNumber();
        int res = as.myAtoi("-91283472332");
        System.out.println(res);
    }

}
