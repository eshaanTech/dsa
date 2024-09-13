package eshaan.learning.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class HouseWithOceanView {
    public static int[] findOceanViewHouses(int[] heights) {
        List<Integer> result = new ArrayList<>();
        int maxSoFar = 0;

        // Traverse from right to left
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxSoFar) {
                result.add(i);  // This house has an ocean view
                maxSoFar = heights[i];  // Update the maximum height seen so far
            }
        }

        // Reverse the result to be in left-to-right order
        int[] oceanViewHouses = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            oceanViewHouses[i] = result.get(result.size() - 1 - i);
        }

        return oceanViewHouses;
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 3, 1};  // Example input
        int[] oceanViewHouses = findOceanViewHouses(heights);
        for (int house : oceanViewHouses) {
            System.out.print(house + " ");
        }
    }
}
