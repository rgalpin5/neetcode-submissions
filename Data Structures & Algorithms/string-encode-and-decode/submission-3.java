class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
            sb.append("#");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int index = 0;
        List<String> ans = new ArrayList<>();
        if(str.length() == 0) return ans;
        int left = 0;
        int right = 0;
        while(right < str.length()) {
            left = right;
            int len = 0;

            while(Character.isDigit(str.charAt(right))){
                right++;
            }
            len = Integer.parseInt(str.substring(left, right));
            left = ++right;
            for (int i = 0; i < len; i++) {
                right++;
            }
            ans.add(str.substring(left, right));
            right++;
        }
        return ans;
    }
}
