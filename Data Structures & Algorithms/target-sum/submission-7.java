class Solution {
    int[][] dp;
    private int getWays(int ind, int[] nums, int target) {
        if(ind == (nums.length - 1)) {
            if(target == 0 && nums[ind] == 0)
                return dp[ind][target] = 2;
            if(nums[ind] == target || target == 0)
                return dp[ind][target] = 1;
            
            return dp[ind][target] = 0;
        }
        if(dp[ind][target] != -1)
            return dp[ind][target];

        // add:
        int t = 0;
        if(target >= nums[ind])
            t = getWays(ind+1, nums, target - nums[ind]);
        
        // sub:
        int nt = getWays(ind+1, nums, target);

        return dp[ind][target] = t + nt;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        target = Math.abs(target);

        for(int i=0;i<n;i++) {
            sum += nums[i];
        }

        if(sum - target < 0)
            return 0;
        if((sum + target) % 2 == 1)
            return 0;
        
        int newTarget = (sum + target)/2;
        this.dp = new int[n][newTarget+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }

        return getWays(0, nums, newTarget);
    }
}
