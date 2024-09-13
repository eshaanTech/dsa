package eshaan.learning.dsa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        //sort the array
        Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++){
            valueMap.put(nums[i], i);
        }
        for(int i=0; i< nums.length; i++){
            if(valueMap.containsKey(target-nums[i])){
                result[0] = valueMap.get(target-nums[i]);
                result[1]= nums[i];
                return result;
            }
        }
        return result;
    }
}
