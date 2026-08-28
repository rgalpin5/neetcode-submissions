class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> s1Freqs = new HashMap<>();
        HashMap<Character, Integer> s2Freqs = new HashMap<>();

        for(char c : s1.toCharArray()){
            s1Freqs.put(c, s1Freqs.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;

        while(r < s1.length()) {
            s2Freqs.put(s2.charAt(r), s2Freqs.getOrDefault(s2.charAt(r), 0) + 1);
            r++;
        }
        if(s2Freqs.equals(s1Freqs)) return true;

        while(r < s2.length()) {
            char rChar = s2.charAt(r);
            char lChar = s2.charAt(l);

            s2Freqs.put(rChar, s2Freqs.getOrDefault(rChar, 0) + 1);
            if(s2Freqs.get(lChar) == 1) s2Freqs.remove(lChar);
            else{
                s2Freqs.put(lChar, s2Freqs.get(lChar) - 1);
            }
            if(s2Freqs.equals(s1Freqs)) return true;
            r++;
            l++;
        }

        return false;
    }
}
