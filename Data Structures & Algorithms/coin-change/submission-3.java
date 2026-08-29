class Solution {

    private int getMinCoins(int ind, int amount, int[] coins, int[][] dp) {
        if(ind == coins.length-1) {
            if(amount % coins[ind] == 0) {
                return dp[ind][amount] = amount/coins[ind];
            }

            return Integer.MAX_VALUE;
        }

        if(dp[ind][amount] != -1)
            return dp[ind][amount];


        // take:
        int take = Integer.MAX_VALUE;
        if(amount >= coins[ind]){
            int res = getMinCoins(ind, amount-coins[ind], coins, dp);
            if(res != Integer.MAX_VALUE)
                take = 1 + res;
        }
        
        // not take:
        int notTake = getMinCoins(ind+1, amount, coins, dp);

        return dp[ind][amount] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = getMinCoins(0, amount, coins, dp);

        return dp[0][amount] >= Integer.MAX_VALUE ? -1 : dp[0][amount];
    }
}
