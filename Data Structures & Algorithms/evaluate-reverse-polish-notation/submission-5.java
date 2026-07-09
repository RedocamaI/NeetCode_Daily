class Solution {
    public List<Integer> process(Deque<String> stack) {
        int a = Integer.parseInt(stack.peek());
        stack.pop();

        int b = Integer.parseInt(stack.peek());
        stack.pop();

        return Arrays.asList(a, b);
    }

    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Deque<String> stack = new ArrayDeque<>();
        List<Integer> operands = new ArrayList<>();
        int val = 0;

        for(int i=0;i<n;i++) {
            if(tokens[i].equals("+")) {
                operands = process(stack);
                val = operands.get(1) + operands.get(0);
                stack.push(String.valueOf(val));
            }else if(tokens[i].equals("-")) {
                operands = process(stack);
                val = operands.get(1) - operands.get(0);
                stack.push(String.valueOf(val));
            }else if(tokens[i].equals("*")) {
                operands = process(stack);
                val = operands.get(1) * operands.get(0);
                stack.push(String.valueOf(val));
            }else if(tokens[i].equals("/")) {
                operands = process(stack);
                val = operands.get(1) / operands.get(0);
                stack.push(String.valueOf(val));
            }else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.peek());
    }
}
