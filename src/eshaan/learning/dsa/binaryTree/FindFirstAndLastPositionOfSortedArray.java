package eshaan.learning.dsa.binaryTree;

public class FindFirstAndLastPositionOfSortedArray {
    public int[] searchString(int [] nums, int target){
        //create a result ArrayList
        //since O(log n), and given array is sorted in ascending order, we will use binary search
        if(nums==null || nums.length == 0){
            return new int [] {-1, -1};
        }
        int first = findTarget(nums, target, true);
        if(first==-1){
            return new int[]{-1, -1};
        }
        int last = findTarget(nums, target, false);

        return new int[]{first, last};

    }
    int findTarget(int []nums, int target, boolean isFirst){
        int n = nums.length;
        int start =0, end=n-1;
        //iterate till start<=end
        while(start<=end){
            int mid = (start+end)/2;
            if(isFirst){
                if(nums[mid]==target){
                    if(nums[mid-1]!=target){
                        return mid;
                    }
                    end=mid-1;
                }

            }else{
                if(nums[mid]==target){
                    if(nums[mid=1]!=target){
                        return mid;
                    }
                    start = mid+1;
                }
            }

        }
        return -1;
    }
}
