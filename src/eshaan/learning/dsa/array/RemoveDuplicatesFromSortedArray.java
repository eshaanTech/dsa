package eshaan.learning.dsa.array;

public class RemoveDuplicatesFromSortedArray {
    //we will create 2-pointers
    //i will always point to unique element and J will find unique element and give to J
    public int removeDuplicates(int[] nums) {
        int i=0, j=1;
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
            j++;
        }
        return i+1;

    }
}
