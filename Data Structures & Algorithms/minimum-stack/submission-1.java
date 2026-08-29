class MinStack {

    /*
    
    Min Stack = Normal Stack + minimum ki history maintain karna.
    stack → actual values store karta hai.
    minStack → har level par current minimum store karta hai.
    push() → value stack mein + current minimum minStack mein.
    pop() → dono stacks se top remove karo.
    top() → stack.peek().
    getMin() → minStack.peek().
    Isliye all operations O(1).
    Extra Space → O(n).
    
    */

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    // private int minVal = Integer.MAX_VALUE;
    
    /* Constructor */
    public MinStack() {}
    
    public void push(int val) {
       int min = minStack.isEmpty() ? val : Math.min(val, minStack.peek());
        stack.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
