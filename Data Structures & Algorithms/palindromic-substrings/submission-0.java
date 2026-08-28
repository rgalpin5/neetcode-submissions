class Solution {
    public int countSubstrings(String s) {
        int palindromeCount = 0;
        for(int i = 0; i<s.length();i++){
            int right = s.length();
            while(right > i){
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(i, right));
                System.err.println(sb.toString());
                if(sb.toString().equals(sb.reverse().toString())){
                    palindromeCount++;
                }
                right--;
            }
        }
        return palindromeCount;
    }
}
