class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charsInString = new HashSet<>();
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        int maxLen = 1;

        int l = 0;
        int r = 0;
        /*
        s="abcabcbb"
        charSet = {c,a}
        l = 2
        r = 4
        maxLen = 3
        */
        while(r < s.length()) {
            while(charsInString.contains(s.charAt(r)) && l < s.length()) {
                charsInString.remove(s.charAt(l));
                l++;
            }
            charsInString.add(s.charAt(r));
            r++;
            maxLen = Math.max(charsInString.size(), maxLen);
        }
        return maxLen;

    }
}
