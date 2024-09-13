package eshaan.learning.dsa.slidingwindow;

public class MaximumAvgSubarray {
    public double findMaxAverage(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return 0.0;
        int left = 0;
        int currSum = 0;
        double maxAvg = Double.valueOf(Integer.MIN_VALUE);
        int n= nums.length;
        for(int i=0; i<n; i++ ){
            currSum += nums[i];
            if(i>=k-1){
                double currAvg = currSum*1.0/k;
                maxAvg = Math.max(maxAvg, currAvg);
                currSum = currSum - nums[left];
                left++;

            }
        }
        return maxAvg;

    }
    public static void main(String[] args){
        MaximumAvgSubarray mas = new MaximumAvgSubarray();
        int[] nums = {-1};
        double maxAvg = mas.findMaxAverage(nums, 1);
        System.out.println(maxAvg);

    }
}
