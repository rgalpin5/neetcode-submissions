class Solution {
    public String longestCommonPrefix(String[] strs) {
        int maxLen = strs[0].length();
        String longPref = strs[0];
        for(String str : strs){
            int temp = 0;
            while(temp<maxLen && temp<str.length() && str.charAt(temp) == longPref.charAt(temp)){
                temp++;
            }
            if(temp < maxLen){
                maxLen = temp;
                longPref = str.substring(0, temp);
            }
        }
        return longPref;
    }
}