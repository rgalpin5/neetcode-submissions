class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r;
        String alphaNum = "";
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                alphaNum += Character.toLowerCase(c);
            }
        }
        r = alphaNum.length() - 1;
        while(l<=r){
            if(alphaNum.charAt(r) != alphaNum.charAt(l)){
                return false;
            }
            r--;
            l++;
        }
        return true;
    }

    
}
