class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int[] prevS = new int[n];
        Arrays.fill(prevS, -1);
        prevS[0] = -1;
        stack.push(0);
        for(int i=1;i<n;i++) {
            int h = heights[i];

            while(!stack.isEmpty() && h <= heights[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                prevS[i] = -1;
            }else {
                prevS[i] = stack.peek();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            stack.pop();
        }

        int[] nextS = new int[n];
        Arrays.fill(nextS, n);
        stack.push(n-1);
        for(int i=n-2;i>=0;i--) {
            int h = heights[i];

            while(!stack.isEmpty() && h <= heights[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                nextS[i] = n;
            }else {
                nextS[i] = stack.peek();
            }
            stack.push(i);
        }

        int ans = 0;
        for(int i=0;i<n;i++) {
            int distance = nextS[i] - prevS[i] - 1;
            int height = heights[i];

            ans = Math.max(ans, distance*height);
        }

        return ans;
    }
}
