class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }

        // base case:
        for(int i=0;i<n;i++) {
            dp[i][0] = 1;
        }
        for(int t=1;t<=amount;t++) {
            dp[n][t] = 0;
        }

        for(int i=n-1;i>=0;i--) {
            for(int t=1;t<=amount;t++) {
                int take = 0;
                // take:
                if(t >= coins[i])
                    take = dp[i][t-coins[i]];
                
                // not take:
                int notTake = dp[i+1][t];

                dp[i][t] = take + notTake;
            }
        }

        return dp[0][amount];
    }
}
