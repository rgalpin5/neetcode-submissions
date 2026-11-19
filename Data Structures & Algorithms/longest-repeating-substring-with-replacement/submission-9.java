class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;

        int currReplacements = 0;
        int max = 0;
        int[] freqs = new int[26];
        int maxFreq = 0;
        for(int right = 0; right < s.length(); right++) {
            int rChar = s.charAt(right) - 'A';
            freqs[rChar]++;
            maxFreq = Math.max(maxFreq, freqs[rChar]);
            
            while((right - left + 1) - maxFreq > k) {
                freqs[s.charAt(left) - 'A']--;
                left++;
            }
            int windowLen = right - left + 1;
           
            max = Math.max(max, windowLen);
        }
        
        return max;
    }
}
