class Solution {
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int numIslands = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++){
                while(!queue.isEmpty()) {
                    int[] index = queue.poll();
                    if(visited[index[0]][index[1]]) continue;
                    int i = index[0];
                    int j = index[1];
                    for(int[] dir : directions) {
                        if(i + dir[0] >= 0 && i + dir[0] < grid.length && j + dir[1] >= 0 && j + dir[1] < grid[0].length && !visited[i+dir[0]][j+dir[1]] && grid[i+dir[0]][j+dir[1]] == '1') {
                            queue.offer(new int[]{i+dir[0],j+dir[1]});
                        }
                    }
                    visited[i][j] = true;
                    grid[i][j] = '0';
                }

                if(grid[row][col] == '1'){
                    queue.offer(new int[]{row,col});
                    numIslands++;
                }

            }
        }
        return numIslands;
    }
}
