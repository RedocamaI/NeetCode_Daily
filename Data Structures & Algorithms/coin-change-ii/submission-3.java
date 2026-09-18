class Solution {
    int[][] dp;
    int getNumCoins(int ind, int amount, int[] coins) {
        if(ind == coins.length)
            return (amount == 0 ? 1 : 0);
        if(amount == 0)
            return 1;
        if(dp[ind][amount] != -1)
            return dp[ind][amount];

        int take = 0;
        // take:
        if(amount >= coins[ind]) {
            take = getNumCoins(ind, amount-coins[ind], coins);
        }

        // not take:
        int notTake = getNumCoins(ind+1, amount, coins);

        return dp[ind][amount] = take + notTake;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        dp = new int[n][amount+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }

        return getNumCoins(0, amount, coins);
    }
}
