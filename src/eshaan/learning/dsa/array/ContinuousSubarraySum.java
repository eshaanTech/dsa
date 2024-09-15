package eshaan.learning.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Edge case: Array must have at least two elements
        if (nums.length < 2) return false;
        // Map to store remainder and the earliest index
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);  // Handle subarrays starting from index 0
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            // If k is not zero, take the modulus
            if (k != 0) {
                prefixSum %= k;
            }
            // Check if we have seen this remainder before
            if (remainderMap.containsKey(prefixSum)) {
                // Ensure the subarray is at least size 2
                if (i - remainderMap.get(prefixSum) > 1) {
                    return true;
                }
            } else {
                // Store the first occurrence of the remainder
                remainderMap.put(prefixSum, i);
            }
        }

        return false;
    }
    public static void main(String[] args) {
        ContinuousSubarraySum solution = new ContinuousSubarraySum();

        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;

        System.out.println(solution.checkSubarraySum(nums, k)); // Output: true
    }
}
