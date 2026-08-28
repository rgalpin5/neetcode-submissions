class Solution {
    public String minWindow(String s, String t) {
        if(s == t) return s;
        HashMap<Character, Integer> tFreqs = new HashMap<>();
        HashMap<Character, Integer> sFreqs = new HashMap<>();
        int freqCount = 0;
        String minSub = "";
        int minStringLen = Integer.MAX_VALUE;
        for(char c : t.toCharArray()){
            tFreqs.put(c, tFreqs.getOrDefault(c, 0)+1);
        }
        int left = 0;
        for(int right = 0;right<s.length();right++){
            char currChar = s.charAt(right);
            sFreqs.put(currChar, sFreqs.getOrDefault(currChar, 0)+1);

            if(tFreqs.containsKey(currChar) && sFreqs.get(currChar) <= tFreqs.get(currChar)){
                freqCount++;
            }

            while(freqCount >= t.length()){
                if(s.substring(left, right+1).length() < minStringLen){
                    minSub = s.substring(left, right+1);
                    minStringLen = minSub.length();
                }
                sFreqs.put(s.charAt(left), sFreqs.get(s.charAt(left))-1);
                if(tFreqs.containsKey(s.charAt(left)) && sFreqs.get(s.charAt(left)) < tFreqs.get(s.charAt(left))) freqCount--;
                left++;
            }


            


        }
        return minSub; 
        
    }
}
