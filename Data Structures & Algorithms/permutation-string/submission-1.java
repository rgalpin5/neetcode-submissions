class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> s1Chars = new HashMap<>();
        HashMap<Character, Integer> s2Chars = new HashMap<>();
        for(char c : s1.toCharArray()){
            s1Chars.put(c, s1Chars.getOrDefault(c, 0) + 1);
        }
        char currChar;
        char leftChar;
        int r = 0;
        while (r<s1.length()){
                currChar = s2.charAt(r);
                s2Chars.put(currChar, s2Chars.getOrDefault(currChar, 0) + 1);
                r++;
        }
        System.err.println(s1Chars);
        while(r < s2.length()){
            leftChar = s2.charAt(l);
            currChar = s2.charAt(r);
            if(s2Chars.equals(s1Chars)){
                return true;
            }
            else{
                s2Chars.put(leftChar, s2Chars.get(leftChar)-1);
                if(s2Chars.get(leftChar) == 0)s2Chars.remove(leftChar);
                l++;
            }
            s2Chars.put(currChar, s2Chars.getOrDefault(currChar, 0) + 1);

            
            r++;
            System.err.println(s2Chars);



        }
        if(s2Chars.equals(s1Chars)) return true;
        return false;
    }
}
