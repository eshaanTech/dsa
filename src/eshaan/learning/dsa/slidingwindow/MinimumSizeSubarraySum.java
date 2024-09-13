package eshaan.learning.dsa.slidingwindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLenBruteForce(int target, int[] nums) {
        int n= nums.length;
        int minSize = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int currSum = 0;
            for(int j=i; j<n; j++){
                currSum += nums[j];
                if(currSum >=target){
                    minSize = Math.min(minSize, j-i+1);
                    break;
                }
            }
        }
        return minSize==Integer.MAX_VALUE ? 0 : minSize;

    }

    public int minSubArrayLen(int target, int[] nums) {
        //[2,3,1,2,4,3] 7
        int n= nums.length;
        int minSize = Integer.MAX_VALUE;
        int l=0;
        int currSum=0;
        for(int r = 0; r<n; r++){
            //add current element to the sum
            currSum+=nums[r];
            while(currSum>=target){
                minSize = Math.min(minSize, r-l+1);
                currSum = currSum-nums[l];
                l++;
            }
        }
        return minSize==Integer.MAX_VALUE ? 0 : minSize;

    }

    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        MinimumSizeSubarraySum mss = new MinimumSizeSubarraySum();
        int size = mss.minSubArrayLen(target, nums);
        System.out.println(size);
    }

}
