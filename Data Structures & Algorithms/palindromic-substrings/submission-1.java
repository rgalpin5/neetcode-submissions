class Solution {
    public int countSubstrings(String s) {
        int count = 1;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        if(n == 1) return n;

        for(int i = n - 2; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i + 1 <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
