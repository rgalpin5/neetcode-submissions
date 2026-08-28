class Solution {

    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] atlanticFlow = new boolean[heights.length][heights[0].length];
        boolean[][] pacificFlow = new boolean[heights.length][heights[0].length];      
        List<List<Integer>> ans = new ArrayList<>();

        for(int c = 0; c < heights[0].length; c++) {
            dfs(heights, atlanticFlow, heights.length - 1, c);
            dfs(heights, pacificFlow, 0, c);
        }

        for(int r = 0; r < heights.length; r++) {
            dfs(heights, atlanticFlow, r, heights[0].length-1);
            dfs(heights, pacificFlow, r, 0);
        }

        

        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++) {
                if(atlanticFlow[i][j] && pacificFlow[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        
        return ans;
    }

    private void dfs(int[][] heights, boolean[][] oceanArr, int row, int col) {
        oceanArr[row][col] = true;
        for(int[] dir : directions) {
            if(row + dir[0] < heights.length && row + dir[0] >= 0 && col + dir[1] >= 0 && col + dir[1] < heights[0].length && heights[row + dir[0]][col + dir[1]] >= heights[row][col] && !oceanArr[row + dir[0]][col + dir[1]]) {
                dfs(heights, oceanArr, row + dir[0], col + dir[1]);
            }
        }


    }
}
