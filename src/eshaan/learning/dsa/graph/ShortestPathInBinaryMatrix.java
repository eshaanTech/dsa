package eshaan.learning.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    // Directions for moving in 8 possible directions (including diagonals)
    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},  // Top-left, top, top-right
            {0, -1},         {0, 1},    // Left, right
            {1, -1}, {1, 0}, {1, 1}     // Bottom-left, bottom, bottom-right
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Check if the starting point or the ending point is blocked
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        // Queue to store the coordinates (i, j)
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        // Mark the start point as visited
        grid[0][0] = 1;
        int pathLength = 1;  // Start path length from 1

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();  // Process one level at a time
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // If we reached the bottom-right corner, return the path length
                if (row == n - 1 && col == n - 1) {
                    return pathLength;
                }

                // Explore all 8 possible directions
                for (int[] direction : DIRECTIONS) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // Check if the new cell is within bounds and is walkable (grid[newRow][newCol] == 0)
                    if (isValid(grid, newRow, newCol)) {
                        // Mark the new cell as visited
                        grid[newRow][newCol] = 1;
                        // Add the new cell to the queue
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
            // Increment the path length after processing the entire level
            pathLength++;
        }

        // If no path was found, return -1
        return -1;
    }

    // Helper function to check if a cell is within bounds and walkable
    private boolean isValid(int[][] grid, int row, int col) {
        int n = grid.length;
        return row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0;
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix solver = new ShortestPathInBinaryMatrix();
        int[][] grid = {
                {0, 1, 0},
                {0, 1, 1},
                {0, 0, 0}
        };
        System.out.println(solver.shortestPathBinaryMatrix(grid));  // Output: 4
    }
}
