class Solution {
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int time = 0;
        while(!queue.isEmpty()) {
            if(fresh == 0) break;
            int length = queue.size();
            for(int i = 0; i < length; i++){
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] dir : directions){
                    int row = r+dir[0];
                    int col = c+dir[1];
                    if(col >= 0 && row >= 0 && col < cols && row < rows && grid[row][col] == 1){
                        grid[row][col] = 2;
                        queue.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            System.out.println(Arrays.deepToString(grid));
            time++;
        }
        
        
        return fresh == 0 ? time : -1;

    }
}
