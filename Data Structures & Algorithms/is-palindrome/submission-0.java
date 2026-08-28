class Solution {
    public boolean isPalindrome(String s) {
        String alphaNum = "";
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                alphaNum += c;
            }
        }
        alphaNum = alphaNum.toLowerCase();
        int l = 0;
        int r = alphaNum.length() - 1;
        System.out.println(alphaNum);
        while(l<=r){
            if(alphaNum.charAt(l) != alphaNum.charAt(r)){
                return false;
            }
            else{
                l++;
                r--;
            }
        }
        return true;
    }
}
