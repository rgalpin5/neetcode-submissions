class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> sFreqs = new HashMap<>();
        HashMap<Character, Integer> tFreqs = new HashMap<>();

        for(char c : s.toCharArray()) {
            sFreqs.put(c, sFreqs.getOrDefault(c, 0) + 1);
        }
        for(char c : t.toCharArray()) {
            tFreqs.put(c, tFreqs.getOrDefault(c, 0) + 1);
        }

        

        return tFreqs.equals(sFreqs);
    }
}
