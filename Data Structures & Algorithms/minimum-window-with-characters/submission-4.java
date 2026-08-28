class Solution {
    public String minWindow(String s, String t) {
        //edge case
        if(t.length() > s.length()) return "";
        //Initialize Vars and Data Structures

        HashMap<Character, Integer> tFreqs = new HashMap<>();
        HashMap<Character, Integer> sFreqs = new HashMap<>();
        int l = 0;
        int r = 0;
        int minSize = Integer.MAX_VALUE;
        String possibleAns = s;
        String ans = "";

        //Calc Frequencies of chars in t
        for(char c : t.toCharArray()) {
            tFreqs.put(c, tFreqs.getOrDefault(c, 0) + 1);
            sFreqs.put(c, 0);
        }
        int have = 0, need = tFreqs.size();


        //open sliding window from l to r until sFreqs = tFreqs
        //close window until we get smallest window with sFreqs = tFreqs
        //open again when we dont have all freqs
        while(r < s.length()) {
            System.out.println(s.substring(l, r+1)); 
            char rightChar = s.charAt(r);
            if(sFreqs.containsKey(rightChar)) {
                sFreqs.put(rightChar, sFreqs.get(rightChar) + 1);
                if(sFreqs.get(rightChar).equals(tFreqs.get(rightChar))) {
                    have++;
                }
            }
            
            while(have == need) {
                char leftChar = s.charAt(l);
                possibleAns = s.substring(l, r + 1);
                if(sFreqs.containsKey(leftChar)){
                    sFreqs.put(leftChar, sFreqs.get(leftChar) - 1);
                    if(sFreqs.get(leftChar) < tFreqs.get(leftChar)) have--;
                } 
                l++;
                if(ans.equals("") || possibleAns.length() < ans.length()) ans = possibleAns;
            }
            r++;
        }

        //return smallest substring
        
        return ans;

    }
}

