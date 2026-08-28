class Solution {
    public String longestPalindrome(String s) {
        

        if(isPalindrome(s)){
            return s;
        }
        int l = 0;
        int r = s.length()-1;
        int rightLen = r;
        String subS;
        while(l<r){
            for(int i = r;i<s.length()+1;i++){
                subS = s.substring(l, r);
                if(isPalindrome(subS)){
                    return subS;
                }
                l++;
                r++;
            }
            l=0;
            rightLen--;
            r = rightLen;

        }
        return s;

    }

    private boolean isPalindrome(String str){
        int r = str.length()-1;
        int l = 0;
        while(l<r){
            if(str.charAt(l) == str.charAt(r)){
                l++;
                r--;
            }
            else{
                return false;
            }
        }
        return true;

    }
}
