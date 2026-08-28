class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder();
        if(digits.length() == 0){
            return ans;
        
        }
        dfs(digits, 0, sb);
        return ans;
    }

    private void dfs(String digits, int i, StringBuilder sb){
        if(i == digits.length()){
            ans.add(sb.toString());
            return;
        }

        System.out.println(sb.toString());
        System.out.println(i);
        if(digits.charAt(i) == '2') {
            sb.append("a");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("b");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("c");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
        }
        else if(digits.charAt(i) == '3') {
            sb.append("d");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("e");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("f");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
        }
        else if(digits.charAt(i) == '4') {
            sb.append("g");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("h");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("i");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
        }
        else if(digits.charAt(i) == '5') {
            sb.append("j");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("k");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("l");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
        }
        else if(digits.charAt(i) == '6') {
            sb.append("m");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("n");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("o");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
        }
        else if(digits.charAt(i) == '7') {
            sb.append("p");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("q");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("r");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("s");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
        }
        else if(digits.charAt(i) == '8') {
            sb.append("t");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("u");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("v");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
        }
        else if(digits.charAt(i) == '9') {
            sb.append("w");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("x");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("y");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
            sb.append("z");
            dfs(digits, i+1, sb);
            sb.deleteCharAt(i);
        }


    }

}
