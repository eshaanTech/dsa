package eshaan.learning.dsa.twopointers;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        //reader pointer i iterares thru the array
        //writer point j keeps track of the none zero elements
        int j=0;
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
            //keep iterating
        }
        for(int i =j; i<n; i++){
            nums[i]=0;
        }

    }
    public static void main(String [] args){
        int[] nums = {0,1,0,3,12};
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes(nums);;
    }

}
