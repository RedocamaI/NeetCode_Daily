class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=n-1;i>=0;i--) {
            int val = temp[i];
            
            while(!stack.isEmpty() && temp[stack.peek()] <= val) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                result[i] = 0;
                stack.push(i);
                continue;
            }

            int days = stack.peek() - i;
            result[i] = days;
            stack.push(i);
        }

        return result;
    }
}
