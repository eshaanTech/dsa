package eshaan.learning.dsa;

import java.util.Stack;

public class LargestRectangleArea {
    //example: {2, , 5, 6, 2, 3}
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> indexStack = new Stack<>();
        int n = heights.length;
        //iterate thru the itesm in the array
        for(int i=0; i<heights.length; i++){
            while(!indexStack.isEmpty() && heights[indexStack.peek()]>heights[i]){//while current bar is shorter then the top bar in the stack calculate the area
                int height = heights[indexStack.pop()];
                //if stack is empty, set the width to value of i, otherwise subtract the value of top of the index from current index
                int width = indexStack.isEmpty()? i : i-indexStack.peek()-1;
                maxArea = Math.max(maxArea, width*height);
            }
            indexStack.push(i);
        }
        while(!indexStack.isEmpty()){ //calculate the area of the bars left in the stack
            int height = heights[indexStack.pop()];
            int width = indexStack.isEmpty()? n : n-indexStack.peek()-1;
            maxArea = Math.max(maxArea, width*height);
        }
        return maxArea;        //time complexity )(N^2)
        //space complexity O(N)

    }
    public int largestRectangleAreaBruteForce(int[] heights) {
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j=0; j<heights.length; j++){
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j-i+1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] histogram = {2, 1, 5, 6, 2, 3};
        LargestRectangleArea lra = new LargestRectangleArea();
        System.out.println("Maximum area is: " + lra.largestRectangleArea(histogram)); // Output: 10
    }
}
