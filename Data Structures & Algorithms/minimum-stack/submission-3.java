class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty()){
            if(minStack.peek() >= val) {
                minStack.push(val);
            }
        }
        else{
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == minStack.peek()) minStack.pop();
    }
    
    public int top() {
        int val = stack.peek();
        return val;
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
