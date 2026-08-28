class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       
       Set<String> wordSet = new HashSet<>(wordDict);
        // memo[i] will store whether the substring s.substring(i) can be broken.
        // We use Boolean to distinguish between three states:
        // null: not computed yet
        // true: can be broken
        // false: cannot be broken
        Boolean[] memo = new Boolean[s.length()];

        return search(s, 0, wordSet, memo);

    }

    private boolean search(String s, int start, Set<String> wordSet, Boolean[] memo) {
        
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (wordSet.contains(word) && search(s, end, wordSet, memo)) {
                // ... then we found a valid segmentation.
                // Store true in our memoization array and return.
                memo[start] = true;
                return true;
            }

            
        }
        memo[start] = false;
        return false;
    }
}
