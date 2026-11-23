class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        final int[][] DIRS = {{-1,0},{1,0},{0,-1},{0,1}};
        int oranges = 0;
        int maxMinutes = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j,0});
                }
                else if(grid[i][j] == 1) oranges++;
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (grid[nr][nc] != 1) continue;
                grid[nr][nc] = 2;
                oranges--;
                queue.offer(new int[]{nr, nc, current[2]+1});
            }
            maxMinutes = Math.max(maxMinutes, current[2]);
        }

        return oranges > 0 ? -1 : maxMinutes;




    }
}
