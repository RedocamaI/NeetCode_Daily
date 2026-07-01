class Solution {
    int[] dp;
    int getMaxMoney(int ind, int n, int[] nums) {
        if(ind < 0)
            return 0;
        if(dp[ind] != -1)
            return dp[ind];

        // take:
        int take = nums[ind] + getMaxMoney(ind-2, n, nums);
        
        // not take:
        int notTake = getMaxMoney(ind-1, n, nums);

        return dp[ind] = Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        this.dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = Math.max(getMaxMoney(n-1, n, nums), 
            getMaxMoney(n-2, n, nums));
        
        return ans;
    }
}
