package eshaan.learning.dsa.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeIntegerInWIndowSIzeK {
    public int[] solve(int [] nums, int k){
        //ex: {12, -1, -7, 8, -15, 30, 16, 28
        /*
        Approach:
        Use queue to keep track of the indices of negatiec numbers within the current window sizez k
        Traverse thru the array, for each element:
            Add the index to the queue if it is negatice
            if the current idx exceeds the window size, remove elements from the queue that are out of the window
            for each window, if the queue is non-empty, the elemented at the from of the queus is the 1st negative integer in the current window
            if the queue is empty, there is no negative integer in the current window so print 0
         */
        //create a queue
        Deque<Integer> deque = new LinkedList<>();
        //arr to stogre the 1st negative numsber
        int[] result = new int[nums.length-k+1];
        int index =0;
        //travers thru the array
        for(int i=0; i<nums.length; i++){
            if(nums[i]<0){
                //if the number is negative, add the number to deque
                deque.addLast(i);
            }
            //remove elements that are out of current window - window size = i-k+1
            if(!deque.isEmpty() && deque.peekFirst() < i-k+1){
                deque.pollFirst();
            }
            //check for the first negatice number
            //if the deque is not empty, the element at the front of the deque is the first negative number for the current window
            if(!deque.isEmpty()){
                result[index++] = nums[deque.peekFirst()];
            }else{
                //if the deque is empty, there is no negative number in the current window, add 0
                result[index++]=0;
            }
        }
        return result;

    }


}
