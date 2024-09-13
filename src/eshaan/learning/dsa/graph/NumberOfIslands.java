package eshaan.learning.dsa.graph;

public class NumberOfIslands {
    int [][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        /*
        Approach:
            1-loop through each cell in the grid
            2-when a "1" is found. It signifies the start of new island so increment the island count
            3-use dfs or bfs to mark all adjacent land connected to the current cell as visited by chaning '1's to '0's
            4-continue this porcess for all cells
         */
        int islandCount = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    islandCount++;
                    dfs(grid, i, j);

                }
            }
        }
        return islandCount;

    }
    public void dfs(char [][] grid, int row, int col){
        //check boundaries
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0){
            return;
        }
        //mark the cell visited
        grid[row][col]=0;
        //check all 4-directions
        for(int[] dir : directions){
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            dfs(grid, newRow, newCol);
        }

    }
}
