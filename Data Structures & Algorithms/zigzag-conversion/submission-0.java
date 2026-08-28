class Solution {
    public String convert(String s, int numRows) {
        int numColumns = (s.length() / 2) + 1;
        char[][] grid = new char[numRows][numColumns];
        int i = 0;
        int j = 0;
        int currChar = 0;
        char c = '#';
        for(char[] row : grid){
            Arrays.fill(row, '_');
        }
        while(currChar < s.length()) {
            while(i < numRows && currChar < s.length()) {
                c = s.charAt(currChar++);
                grid[i][j] = c;
                i++;
            }
            i--;

            while((i > 0) && currChar < s.length()) {
                i--;
                j++;
                c = s.charAt(currChar++);
                grid[i][j] = c;
            }
            i++;
        }
        
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.deepToString(grid));
        for(char[] row : grid) {    
            for(char ch : row){

                if(ch != '_') sb.append(ch);
            }
        }
        return sb.toString();
    }
}

//GOOGLEISHIRING; str length 14
//3: 7
//4: 7
//5: 6