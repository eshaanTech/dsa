package eshaan.learning.dsa.array;
public class NextPermutation{
    public void nextPermutation(int[] nums){
        if(nums==null || nums.length==0)
            return;
        int n = nums.length -2;//3-2=1
        while(n>=0 && nums[n]>=nums[n+1]){//nums[n]=2 nums[n=1]=3
            n--;
        }
        //step-2: if we found a valid n, find the element just larger than nums[n]
        if(n>=0){//n=1
            int j = nums.length-1;//j = 2
            while(nums[j]<=nums[n]){//nums[j]=3 nums[n]=2
                j--;
            }
            //step 3: swap the numbers at i and j
            swap(nums, n, j);
        }
        //step 4: revers the part of the array after index n
        reverse(nums, n+1, nums.length-1);
    }
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end]=temp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 3};
        NextPermutation np = new NextPermutation();
        np.nextPermutation(nums);
        for(int num : nums){
            System.out.println(num);
        }
    }

}
