class Solution {
    public String minWindow(String s, String t) {
        int[] sFreqs = new int[128];
        int[] tFreqs = new int[128];
        int tChars = t.length();
        for(char c : t.toCharArray()) {
            tFreqs[c]++;
        }
        int left = 0;
        int right = 0;
        int counter = 0;
        String ans = "";
        int length = Integer.MAX_VALUE;

        while(right < s.length()) {
            char rightChar = s.charAt(right);
            if(tFreqs[rightChar] > 0) {
                if(sFreqs[rightChar] < tFreqs[rightChar]) {
                    counter++;
                }
                sFreqs[rightChar]++;
            }
            while(counter == tChars) {
                if(right - left + 1 < length) {
                    ans = s.substring(left, right + 1);
                    length = right - left + 1;
                }
                char leftChar = s.charAt(left);
                if(tFreqs[leftChar] > 0 && sFreqs[leftChar] > tFreqs[leftChar]) {
                    sFreqs[leftChar]--;
                }
                else if(tFreqs[leftChar] > 0 && sFreqs[leftChar] == tFreqs[leftChar]) {
                    sFreqs[leftChar]--;
                    counter--;
                }
                left++;
            }
            right++;
        }

        return ans;
    }
}
