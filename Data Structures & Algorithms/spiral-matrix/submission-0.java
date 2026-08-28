class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> numList = new ArrayList<>();

        int rowLength = matrix[0].length;
        int colLength = matrix.length;
        int totalCells = rowLength * colLength;
        int topPointer = 0;
        int rightPointer = matrix[0].length;
        int botPointer = matrix.length;
        int leftPointer = 0;
        int i = 0;
        int j = 0;
        

        while(numList.size() < totalCells) {
            while(j < rightPointer){
                numList.add(matrix[i][j]);
                j++;
            }
            j--;
            rightPointer--;
            i++;
            if(numList.size() >= totalCells) break;
            while(i < botPointer){
                numList.add(matrix[i][j]);
                i++;
            }
            botPointer--;
            i--;
            j--;
            if(numList.size() >= totalCells) break;
            while(j >= leftPointer){
                numList.add(matrix[i][j]);
                j--;
            }
            j++;
            leftPointer++;
            i--;
            if(numList.size() >= totalCells) break;
            while(i > topPointer) {
                numList.add(matrix[i][j]);
                i--;
            }
            i++;
            topPointer++;
            j++;
        }
        return numList;
    }
}
