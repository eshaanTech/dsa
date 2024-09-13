package eshaan.learning.dsa;

public class PowerFunction {
    public static double myPow(double x, int n) {
        // Base case: n == 0, any number to the power of 0 is 1
        if (n == 0) {
            return 1.0;
        }
        // Recursive case: exponentiation by squaring
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            if(n>0){
                return half * half * x;
            }else{
                return (half * half)/x;
            }
        }
    }
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        System.out.println(x + " raised to the power " + n + " is: " + myPow(x, n));
        System.out.println(myPow(2.0, -2)); // 0.25
    }
}
