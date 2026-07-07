class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prevLargest = new int[n];
        int[] nextLargest = new int[n];

        prevLargest[0] = -1;
        int largestInd = 0;
        for(int i=1;i<n;i++) {
            prevLargest[i] = largestInd;
            if(height[largestInd] <= height[i]) {
                largestInd = i;
            } 
        }

        nextLargest[n-1] = -1;
        largestInd = n-1;
        for(int i=n-2;i>=0;i--) {
            nextLargest[i] = largestInd;
            if(height[largestInd] <= height[i]) {
                largestInd = i;
            }
        }

        int ans = 0;
        for(int i=1;i<n-1;i++) {
            int h = Math.min(height[prevLargest[i]], 
                height[nextLargest[i]]);

            if(height[i] >= h)
                continue;
            
            int heightDiff = h - height[i];
            ans += heightDiff;
        }

        return ans;
    }
}
