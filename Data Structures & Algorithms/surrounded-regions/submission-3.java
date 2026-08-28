class Solution {

    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int ROWS, COLS;
    boolean[][] isSurrounded;
    boolean[][] visited;
    public void solve(char[][] board) {
        
        ROWS = board.length;
        COLS = board[0].length;

        visited = new boolean[ROWS][COLS];
        isSurrounded = new boolean[ROWS][COLS];
        for(boolean[] r : isSurrounded) {
            Arrays.fill(r, true);
        }

        Queue<int[]> queue = new LinkedList<>();
        
        int row = 0;
        int col = 0;

        while(col < COLS) {
            if(board[row][col] == 'O'){
                queue.offer(new int[]{row, col});
            }
            col++;
        }
        col--;

        while(row < ROWS) {
            if(board[row][col] == 'O'){
                queue.offer(new int[]{row, col});
            }
            row++;
        }
        row--;

        while(col >= 0) {
            if(board[row][col] == 'O'){
                queue.offer(new int[]{row, col});
            }
            col--;
        }
        col++;

        while(row >= 0) {
            if(board[row][col] == 'O'){
                queue.offer(new int[]{row, col});
            }
            row--;
        }

        while(!queue.isEmpty()) {
            int[] currIndex = queue.poll();
            int currRow = currIndex[0];
            int currCol = currIndex[1];
            isSurrounded[currRow][currCol] = false;

            

            for(int[] dir : directions) {
                if(currRow + dir[0] >= 0 && currRow + dir[0] < ROWS && currCol + dir[1] >= 0 && currCol + dir[1] < COLS && board[currRow + dir[0]][currCol + dir[1]] == 'O' && !visited[currRow + dir[0]][currCol + dir[1]]){
                    queue.offer(new int[]{currRow+dir[0], currCol+dir[1]});
                    visited[currRow + dir[0]][currCol + dir[1]] = true;
                }
            }
        }

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(isSurrounded[r][c] == true) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    
}
