class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 1) return 1;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int currentLength = 0;
        int l = 0;
        int r = 0;
        char mostOccuring = s.charAt(0);
        int ans = 0;
        /*
        s="AAAAABBBBCBB"
        k=3
        freqMap = {{A,4}{B,4}{C}}
        l = 0
        r = 8
        ans = 8
        leftChar = 'A'
        currentLength - freqMap.get(mostOccuring) = 4
        currentLength =  8
        mostOccuring = 'A'
        currChar = 'B'
        s.length() = 12
        */
        while(r < s.length()) {
            char currChar = s.charAt(r);
            freqMap.put(currChar, freqMap.getOrDefault(currChar, 0) + 1);
            currentLength++;
            if(freqMap.get(currChar) >= freqMap.get(mostOccuring)) {
                mostOccuring = currChar;
            }
            while(currentLength - freqMap.get(mostOccuring) > k) {
                char leftChar = s.charAt(l);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if(freqMap.get(currChar) >= freqMap.get(mostOccuring)) {
                    mostOccuring = currChar;
                }
                l++;
                currentLength--;
            }
            ans = Math.max(ans, currentLength);
            r++;
        }
        return ans;
    }
}
