class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(token.equals("+")) {
                int temp = stack.pop();
                temp += stack.pop();
                stack.push(temp);
            }
            else if(token.equals("-")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 - temp1);
            }
            else if(token.equals("*")) {
                int temp = stack.pop();
                temp *= stack.pop();
                stack.push(temp);
            }
            else if(token.equals("/")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
