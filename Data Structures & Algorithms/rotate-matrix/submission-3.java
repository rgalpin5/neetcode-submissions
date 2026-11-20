class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int[] row : matrix) {
            reverseRow(row);
        }
        
    }

    public void reverseRow(int[] row) {
        int n = row.length;
        for(int i = 0; i < n / 2; i++) {
            int temp = row[i];
            row[i] = row[n - i - 1];
            row[n - i - 1] = temp;
        }
    }
}
