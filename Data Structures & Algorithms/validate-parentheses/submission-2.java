class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }
            else if(c == '{'){
                stack.push(c);
            }
            else if(c == '['){
                stack.push(c);
            }
            else if(c == ']'){
                if(stack.empty()){
                    return false;
                }
                
                else if(stack.peek() != '['){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            else if(c == '}'){
                if(stack.empty()){
                    return false;
                }
                
                else if(stack.peek() != '{'){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            else if(c == ')'){
                if(stack.empty()){
                    return false;
                }
                
                else if(stack.peek() != '('){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}
