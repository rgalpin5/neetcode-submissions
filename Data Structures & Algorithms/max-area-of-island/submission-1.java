class Solution {
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int maxIsland = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    maxIsland = Math.max(dfs(i, j, grid), maxIsland);
                }
            }
        }
        return maxIsland;
    }

    private int dfs(int i, int j, int[][] grid) {
        if(grid[i][j] == 0) return 0;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        visited[i][j] = true;
        if(i > 0 && !visited[i -1][j]){
            num1 = dfs(i-1, j, grid);
        }
        if(i < grid.length - 1 && !visited[i + 1][j]){
            num2 = dfs(i + 1, j, grid);
        }
        if(j < grid[i].length - 1 && !visited[i][j + 1]){
            num3 = dfs(i, j + 1, grid);
        }
        if(j > 0 && !visited[i][j - 1]){
            num4 = dfs(i, j - 1, grid);
        }

        return 1 + num1 + num2 + num3 + num4;
    }
}
