package eshaan.learning.dsa.heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("The " + k + "th largest element is: " + solution.findKthLargest(nums, k)); // Output: 5
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for(int i : nums){
            minHeap.add(i);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
