package eshaan.learning.dsa.array;

public class MaxWaterContainer {
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);

    }
    public static int maxArea(int[] height) {
        int left = 0;//
        int right = height.length-1;//8
        int maxArea = 0;
        while(left<right){
            int minHeight = Math.min(height[left], height[right]);
            int width = right-left;
            int currentArea = minHeight * width;
            maxArea = Math.max(maxArea, currentArea);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;

    }
}
