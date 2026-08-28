class Solution {
    public void setZeroes(int[][] matrix) {
        boolean topIsZero = false;
        

        

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    if(row > 0) {
                        matrix[row][0] = 0;
                    }
                    else{
                        topIsZero = true;
                    }
                    
                }
            }
        }

        for(int r = 1; r < matrix.length; r++) {
            for(int c = 1; c < matrix[0].length; c++) {
                if(matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        if(matrix[0][0] == 0) {
            for(int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }
       
        if(topIsZero) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
