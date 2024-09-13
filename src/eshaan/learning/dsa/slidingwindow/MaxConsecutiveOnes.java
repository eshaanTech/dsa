package eshaan.learning.dsa.slidingwindow;

public class MaxConsecutiveOnes {

    public int longestOnes(int[] nums, int k) {
        //create 2-pointers right and left.
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                if(nums[left]==0){
                    k++;
                }
                left++;
            }
        }
        return right - left;
    }
    public int longestOnesBruteForce(int[] nums, int k) {
        //base case
        if(nums==null || nums.length==0){
            return 0;
        }
        int n=nums.length;
        int maxCount = 0;
        for(int i=0; i<n; i++){
            int currCount = 0;
            int kRemaining = k;
            for(int j=i; j<n;j++){
                if(nums[j]==1){
                    currCount++;
                }else if(kRemaining>0){
                    currCount++;
                    kRemaining--;
                }else{
                    maxCount = Math.max(maxCount, currCount);
                    break;
                }
            }
        }
        return maxCount;
    }

    public static void main (String [] args){
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
        int maxCount = mco.longestOnes(nums, k);
        System.out.println(maxCount);

    }
}
