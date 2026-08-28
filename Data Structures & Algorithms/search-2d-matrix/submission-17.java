class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Binary search to find the correct row
        int top = 0;
        int bottom = rows - 1;
        int potentialRow = -1;
        while(top<=bottom){
            int midRow = top + (bottom - top) / 2;
            if(matrix[midRow][0] <= target && target <= matrix[midRow][cols-1]){
                potentialRow = midRow;
                break;
            }
            else if(matrix[midRow][0] > target){
                bottom = midRow-1;
            }
            else{
                top = midRow+1;
            }
        }
        if(potentialRow == -1) return false;

        int l = 0;
        int r = cols-1;
        int m = r/2;

        while(l<=r){
            m = l + (r - l) / 2;
            if (matrix[potentialRow][m] == target) {
                return true;
            }
            else if(target > matrix[potentialRow][m]){
                l = m+1;
            }
            else{
                r=m-1;
            }
        }

        return false;
    }
}
