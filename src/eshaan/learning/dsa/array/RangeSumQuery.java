package eshaan.learning.dsa.array;

public class RangeSumQuery {
    int[] prefixArray;//{-2--, -2, 1--, -4, -2, -3}
    public RangeSumQuery(int[] nums) {
        prefixArray = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            prefixArray[i+1]=prefixArray[i]+nums[i];
        }

    }

    public int sumRange(int left, int right) {
        //ex: [-2, 0, 3, -5, 2, -1]
        int rightSum = prefixArray[right+1];
        int leftSum = left==0?0:prefixArray[left];
        return rightSum - leftSum;
    }
}
