class MinStack {
    // [val, min] -> min is the minimum value for the top 
    List<Integer> stack;
    List<Integer> minStack;
    Integer size;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.minStack = new ArrayList<>();
        this.size = 0;
    }
    
    public void push(int val) {
        this.stack.add(Integer.valueOf(val));
        if (this.size == 0) {
            this.minStack.add(val);
        } else {
            this.minStack.add(Math.min(val, this.getMin()));
        }
        this.size++;
    }
    
    public void pop() {
        stack.remove(this.size-1);
        minStack.remove(this.size-1);
        this.size--;
    }
    
    public int top() {
        return this.stack.get(size-1);
    }
    
    public int getMin() {
        return this.minStack.get(size-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */