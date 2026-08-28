class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;
        boolean[][] dp = new boolean[n][n];
        int startIndex = 0;
        int wordLen = 0;
        for(int i = n - 2; i >= 0; i--){
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i + 1 <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if(j - i + 1 > wordLen) {
                        wordLen = j - i + 1;
                        startIndex = i;
                    }
                }
            }
        }

        return s.substring(startIndex, startIndex + wordLen);
    }
}
