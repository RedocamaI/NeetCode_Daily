class Solution {
    public int maxArea(int[] heights) {
        int ans = Integer.MIN_VALUE;
        int n = heights.length;

        int i = 0;
        int j = n-1;
        while(i < j) {
            int water = (j-i)*Math.min(heights[i], heights[j]);
            if(heights[i] < heights[j])
                i++;
            else    j--;

            ans = Math.max(ans, water);
        }

        return ans;
    }
}
