class MinStack {

    Deque<List<Integer>> stack = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        int min = val;
        if(!stack.isEmpty())
            min = Math.min(min, stack.peek().get(1));

        stack.push(List.of(val, min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().get(0);
    }
    
    public int getMin() {
        return stack.peek().get(1);
    }
}
