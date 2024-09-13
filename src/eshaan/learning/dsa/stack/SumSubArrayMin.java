package eshaan.learning.dsa.stack;
/*
Approach:
 /*
    Usr monotonic stack to efficiently compute the contribution of each element as the minimum in all subarrays where it is the minimum
    for each element arr[i], detemine how many subarrays it is the minimum of - to do this find the NSL (Next Smaller Left) and NSR
    the number of Sub Array where arr[i] is the minimum is given by (i - NSL) * (NSR - i)
    the contribution of arr[i] to the final sum is -> arr[i] * [i-NSL] * [NSR - i);
 */

import java.util.Stack;

public class SumSubArrayMin {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;

        // Arrays to store the previous and next smaller elements' indices
        int[] prev = new int[n];
        int[] next = new int[n];

        // Monotonic stack for previous smaller elements
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack for reuse
        stack.clear();

        // Monotonic stack for next smaller elements
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the sum of minimums
        long result = 0;
        for (int i = 0; i < n; i++) {
            long totalSum = (long) arr[i] * (i - prev[i]) * (next[i] - i);
            result = (result + totalSum) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        SumSubArrayMin solution = new SumSubArrayMin();
        //int[] arr = {3, 1, 2, 4};
        int[] arr = {11,81,94,43,3};
        System.out.println(solution.sumSubarrayMins(arr)); // Output: 17
    }
}
