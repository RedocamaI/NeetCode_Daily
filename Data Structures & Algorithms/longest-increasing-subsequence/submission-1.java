class Solution {
    int[][] dp;
    int getMaxLength(int ind, int prev, int[] nums) {
        if(ind > nums.length)
            return 0;
        if(dp[ind][prev] != -1)
            return dp[ind][prev];

        int take = 0;
        if(prev == 0 || nums[prev-1] < nums[ind-1]) {
            take = 1 + getMaxLength(ind+1, ind, nums);
        }

        int notTake = getMaxLength(ind+1, prev, nums);

        return dp[ind][prev] = Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        this.dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++) {
            Arrays.fill(dp[i], -1);
        }

        return getMaxLength(1, 0, nums);
    }
}
