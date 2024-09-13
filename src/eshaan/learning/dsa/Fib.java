package eshaan.learning.dsa;

public class Fib {
    public int fib(int n) {
        if(n<=1)
            return n;
        return fib(n-1) + fib(n-2);

    }
    public int fibBottomUp(int n) {
        if(n<=1)
            return n;
        int[] cache = new int[n+1];
        cache[1] = 1;
        for(int i=2; i<=n; i++){
            cache[i]=cache[i-1]+cache[i-2];
        }
        return cache[n];

    }
}
