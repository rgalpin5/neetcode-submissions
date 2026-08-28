class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        int tempNum = 0;
        for(int i = 0;i<tokens.length;i++){
if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){                numStack.push(Integer.parseInt(tokens[i]));
            }
            else{
                if(tokens[i].charAt(0) == '+'){
                    tempNum = numStack.pop() + numStack.pop();
                }
                else if(tokens[i].charAt(0) == '-'){
                    tempNum = -numStack.pop() + numStack.pop();
                }
                else if(tokens[i].charAt(0) == '*'){
                    tempNum = numStack.pop() * numStack.pop();
                }
                else if(tokens[i].charAt(0) == '/'){
                    int n1 = numStack.pop();
                    int n2 = numStack.pop();
                    if(n1 == 0|| n2 == 0) tempNum = 0;
                    else tempNum = n2/n1;
                    
                }
                numStack.push(tempNum);
            }
        }
        return numStack.pop();
    }
}
