package eshaan.learning.dsa.array;

public class ProductArrayExceptSelf {
    public static void main (String []args){
        ProductArrayExceptSelf ps = new ProductArrayExceptSelf();
        int[]nums = {1,2,3,4};
        int [] result = ps.productExceptSelf(nums);
        System.out.println(result.length);
    }

    /*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.
    Input: nums = [1,2,3,4]
    pfix={1, 1, 2, 6}
    post fix = {24, 12, 4, 1}
    Output: [24,12,8,6]
     */
    public int[] productExceptSelf(int[] nums) {
        //base case
        if(nums == null || nums.length<1){
            return nums;
        }
        //lets calculate prodcut of pfix
        int[]result = new int [nums.length];
        int pfix = 1;
        for(int i=0; i<nums.length; i++){
            if(i-1<0){
                result[i]=pfix;
            }else{
                pfix=nums[i-1] * pfix;
                result[i]= pfix;
            }

        }
        //calculate post fix
        int postFix = 1;
        for(int i=nums.length-1; i>=0; i--){
            if(i==nums.length-1){
                result[i]= result[i] * postFix;
            }else{
                postFix = nums[i+1] * postFix;
                result[i]=result[i]*postFix;
            }

        }
        return result;
    }

}
