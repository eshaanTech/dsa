package eshaan.learning.dsa;

public class ReverseInteger {
    public int reverse(int x) {
        int reversed = 0;
        while(x!=0){
            //pop the last digit
            int pop = x%10;
            x = x/10;
            //check for overflow condition
            if(reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE && pop>7)){
                return 0;
            }
            //check for underflow condition
            if(reversed < Integer.MIN_VALUE || (reversed == Integer.MIN_VALUE/10 && pop < -8)){
                return 0;
            }
            reversed = reversed * 10 + pop;
        }
        return reversed;
    }
    public static void main (String[] args){
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(123));
        System.out.println(ri.reverse(320));
    }
}
