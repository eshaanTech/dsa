package eshaan.learning.dsa.array;

public class MInimumInRotatedSortedArray {
    public static void main (String[] args){
        int[]nums = {4,5,6,7,0,1,2};
        int min = findMin(nums);
        System.out.println(min);

    }
    public static int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int start = 0;
        int end = nums.length-1;

        if(nums[start]<nums[end]){
            return nums[start];
        }

        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]>nums[end]){
                start = mid +1;
            }else{
                end = mid;

            }
        }
        return nums[start];
    }
}
