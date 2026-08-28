class Solution {
     private int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private boolean[][] visited;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        // It's often cleaner to store these as member variables to avoid passing them in every recursive call.
        this.board = board;
        this.word = word;
        int rows = board.length;
        int cols = board[0].length;
        this.visited = new boolean[rows][cols];

        // Loop through every cell to find a potential starting point.
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // *** FIX 1: Only start the search if the cell matches the FIRST character of the word.
                if (board[row][col] == word.charAt(0)) {
                    if (search(row, col, 0)) {
                        return true; // Found the word!
                    }
                }
            }
        }
        return false;
    }

    private boolean search(int row, int col, int index) {
        if(index == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || 
            visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        visited[row][col] = true;
        for(int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (search(newRow, newCol, index + 1)) {
                return true; // If any path returns true, we're done.
            }
        }
        visited[row][col] = false;
        return false;
    }
}
