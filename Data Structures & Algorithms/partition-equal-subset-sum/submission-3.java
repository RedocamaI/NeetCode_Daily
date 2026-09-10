class Solution {
    int[][] dp;
    private boolean isPossible(int i, int[] nums, int target) {
        if(i == nums.length)
            return target == 0;
        if(dp[i][target] != -1)
            return dp[i][target] == 1;

        boolean take = false;
        // take:
        if(target >= nums[i])
            take = isPossible(i+1, nums, target-nums[i]);

        // not take:
        boolean notTake = isPossible(i+1, nums, target);

        dp[i][target] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
        }

        if(sum % 2 == 1)
            return false;
        
        int target = sum/2;
        this.dp = new int[n][target+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }

        return isPossible(0, nums, target);
    }
}
