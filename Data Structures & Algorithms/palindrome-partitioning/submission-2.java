class Solution {
    ArrayList<List<String>> ans = new ArrayList<>();
    ArrayList<String> part = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, 0, s);
        return ans;
    }

    private void dfs( int j, int i, String s) {
        if (i >= s.length()) {
            if (i == j) {
                ans.add(new ArrayList<>(part));
            }
            return;
        }
        if (isPalindrome(s, j, i)){
            part.add(s.substring(j, i + 1));
            dfs(i + 1, i + 1, s);
            part.remove(part.size() - 1);
        }

        dfs(j, i+1, s);

        
    }

    private boolean isPalindrome(String sub, int l, int r) {
        
        while(l < r){
            if(sub.charAt(l) != sub.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
