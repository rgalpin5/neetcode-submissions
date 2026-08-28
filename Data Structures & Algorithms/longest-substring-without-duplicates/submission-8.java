class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int n = s.length();
        int maxLength = 0;
        int left = 0;

        for(int right = 0;right<n;right++){
            char currentChar = s.charAt(right);

            while(charSet.contains(currentChar)){
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));

            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}
