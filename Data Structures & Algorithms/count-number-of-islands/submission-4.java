class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while(!queue.isEmpty()) {
                        int[] idx = queue.poll();
                        int r = idx[0];
                        int c = idx[1];
                        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                        for (int[] d : dirs) {
                            int nr = r + d[0];
                            int nc = c + d[1];
                            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && !visited[nr][nc] && grid[nr][nc] == '1') {
                                visited[nr][nc] = true;
                                queue.offer(new int[]{nr, nc});
                            }
                        }

                    }
                    count++;
                }
            }
        }
        return count;
    }
}
