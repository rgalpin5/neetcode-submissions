class Solution {
    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        Queue<int[]> queue = new LinkedList<>();
        int numsWhile = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    queue.offer(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!queue.isEmpty()){
                        int[] currIndex = queue.poll();
                        int row = currIndex[0];
                        int col = currIndex[1];
                        for(int[] dir : directions) {
                            if(row+dir[0] < grid.length && row+dir[0] >= 0 && col+dir[1] >= 0 && col+dir[1] < grid[i].length && grid[row+dir[0]][col+dir[1]] == '1') {
                                queue.offer(new int[]{row+dir[0], col+dir[1]});
                                grid[row+dir[0]][col+dir[1]] = '0';
                            }
                        }
                        
                        
                    }
                    numIslands++;
                }
                
            }
        }
        return numIslands;
    }
}
