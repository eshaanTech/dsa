package eshaan.learning.dsa.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Input: nums = [-1,0,1,2,-1,-4]
Target = 0
Output: [[-1,-1,2],[-1,0,1]]
Approach:
    sort the array
    fix one number n1 and find other 2-numbers n2+n3 that sum up to -n1 so that total is 0
    iterate thru the loop and set each number to n1 and try to find n2+n3


 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        if(nums==null || nums.length<3){
            return result;
        }
        //sort the array since we are interested in elements not indices
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0; i<n-1; i++){
            //handle duplicates
            if(i>0 && nums[i]==nums[i-1]){
                //skip
                continue;
            }
            //initialize variable
            int left = i+1;
            int right = n-1;
            int target = -nums[i];//to find the total sum to 0
            //iterate thry the array t{o find n2 and n3
            while (left < right){
                int sum = nums[left]+nums[right];
                if(sum==target){
                    //add to the values to the list
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //skip the duplicate in left
                    while(left<right && nums[left] == nums [left+1]){
                        left++;
                    }
                    while(left<right && nums[right] == nums [left-1]){
                        right--;
                    }
                    left++;
                    right--;

                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }

            }

        }
        return result;

    }
}
