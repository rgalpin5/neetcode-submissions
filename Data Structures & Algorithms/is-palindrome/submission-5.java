class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1; 
        
        while(l < r) {
            //Left char is first alphanumeric found
            while(l < s.length() && !Character.isDigit(s.charAt(l)) && !Character.isLetter(s.charAt(l))){
                l++;
            }
            if(l >= s.length()) break; 
            char leftChar = Character.toLowerCase(s.charAt(l));
            //right char is first alphanumeric found
            while(r >= 0 && !Character.isDigit(s.charAt(r)) && !Character.isLetter(s.charAt(r))){
                r--;
            }
            if(r < 0) break; 
            char rightChar = Character.toLowerCase(s.charAt(r));

            if(leftChar != rightChar) return false;
            l++;
            r--;
        }

        return true;
    }
}
