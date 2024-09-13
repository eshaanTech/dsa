package eshaan.learning.dsa.array;

/*
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
A good subarray is a subarray where:
    its length is atleast two, and
    the sum of the elements of the subarray is a multiple of k.
    Input: nums = [23,2,4,6,7], k = 6
        Output: true
        Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 */

import java.util.HashMap;

public class CheckSubArraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixMod = 0;
        HashMap<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;

            if (modSeen.containsKey(prefixMod)) {
                // ensures that the size of subarray is at least 2
                if (i - modSeen.get(prefixMod) > 1) {
                    return true;
                }
            } else {
                // mark the value of prefixMod with the current index.
                modSeen.put(prefixMod, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckSubArraySum sol = new CheckSubArraySum();

        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println(sol.checkSubarraySum(nums1, k1)); // Output: true

        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 13;
        System.out.println(sol.checkSubarraySum(nums2, k2)); // Output: false
    }

}
