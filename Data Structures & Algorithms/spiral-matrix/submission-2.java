class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int topBound = 0;
        int botBound = matrix.length - 1;
        int leftBound = 0;
        int rightBound = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();
        int area = matrix.length * matrix[0].length;

        int total = 0;
        while(total < area) {
            for(int col = leftBound; col <= rightBound && total < area; col++) {
                ans.add(matrix[topBound][col]);
                total++;
                
            }
            topBound++;
            for(int row = topBound; row <= botBound && total < area; row++) {
                ans.add(matrix[row][rightBound]);
                total++;
            }
            rightBound--;
            for(int col = rightBound; col >= leftBound && total < area; col--) {
                ans.add(matrix[botBound][col]);
                total++;
            }
            botBound--;
            for(int row = botBound; row >= topBound && total < area; row--) {
                ans.add(matrix[row][leftBound]);
                total++;
            }
            leftBound++;
        }
        return ans;
    }
}
