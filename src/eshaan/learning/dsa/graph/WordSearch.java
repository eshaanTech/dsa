package eshaan.learning.dsa.graph;

public class WordSearch {
    static int [][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col;j++){
                if(board[i][j]==word.charAt(0) && dfs(board, word, i, j, 1))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char [][]board, String word, int row, int col, int idx){
        if(idx == word.length())
            return true;
        char temp = board[row][col];
        board[row][col] = ' ';
        for(int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >= 0 && newRow<board.length && newCol >= 0 && newCol < board[0].length && board[newRow][newCol]==word.charAt(idx)){
                if(dfs(board, word, newRow, newCol, idx+1))
                    return true;
            }
        }
        board[row][col]=temp;
        return false;
    }
}
