class Solution {
    List<Integer> operate(Deque<String> stack) {
        int a = Integer.parseInt(stack.peek());
        stack.pop();

        int b = Integer.parseInt(stack.peek());
        stack.pop();

        return Arrays.asList(a, b);
    }

    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Deque<String> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int val = 0;
        for(int i=0;i<n;i++) {
            if(tokens[i].equals("+")) {
                list = operate(stack);
                val = list.get(1) + list.get(0);
                stack.push(String.valueOf(val));
            }else if(tokens[i].equals("-")) {
                list = operate(stack);
                val = list.get(1) - list.get(0);
                stack.push(String.valueOf(val));
            }else if(tokens[i].equals("*")) {
                list = operate(stack);
                val = list.get(1) * list.get(0);
                stack.push(String.valueOf(val));
            }else if(tokens[i].equals("/")) {
                list = operate(stack);
                val = list.get(1) / list.get(0);
                stack.push(String.valueOf(val));
            }else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.peek());
    }
}
