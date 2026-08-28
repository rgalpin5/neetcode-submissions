class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] charFreq = new int[26];
        int maxFreq = 0;

        for(int right = 0; right < s.length();right++){
            char currentChar = s.charAt(right);
            
            charFreq[currentChar - 'A']++;
            
            maxFreq = Math.max(charFreq[currentChar - 'A'], maxFreq);

            while(right-left+1-maxFreq > k&&left<s.length()){
                charFreq[s.charAt(left) - 'A']--;
                left++;
            }
            


        }
        return Math.min(maxFreq+k, s.length());
    }
}
