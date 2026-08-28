class Solution {
    private final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private final int INF = 2147483647; 
    private final int TREASURE = 0;
    private final int WALL = -1;

    public void islandsAndTreasure(int[][] grid) {
         if (grid == null || grid.length == 0) {
            return;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == TREASURE){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];

            for(int[] dir : DIRECTIONS){
                int r = row + dir[0];
                int c = col + dir[1];

                if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != INF) {
                    continue;
                }

                grid[r][c] = grid[row][col] + 1;
                queue.offer(new int[]{r, c});
            }
        }
    }
}
