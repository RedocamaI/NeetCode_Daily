class Solution {
    private int[][] dp;
    private int getMaxProfit(int ind, int buy, int[] prices) {
        if(ind == prices.length)
            return 0;
        if(dp[ind][buy] != -1)
            return dp[ind][buy];

        int profit = 0;
        // sell at > ind
        if(buy == 1) {
            for(int i=ind+1;i<prices.length;i++) {
                if(prices[i] < prices[ind])
                    continue;
                profit = Math.max(profit, (prices[i] - prices[ind]) + 
                    getMaxProfit(i, 2, prices));
            }
        }else if(buy == 2) {
            for(int i=ind+2;i<prices.length;i++) {
                profit = Math.max(
                    profit, Math.max(
                        getMaxProfit(i, 0, prices),
                        getMaxProfit(i, 1, prices)
                    )
                );
            }
        }else {
            profit = Math.max(
                profit, Math.max(
                    getMaxProfit(ind+1, buy, prices),
                    getMaxProfit(ind+1, 1, prices)
                ));
        }

        return dp[ind][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        dp = new int[n][3];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }

        return Math.max(
            getMaxProfit(0, 0, prices),
            getMaxProfit(0, 1, prices)
        );
    }
}
