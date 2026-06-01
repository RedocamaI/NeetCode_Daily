class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;

        for(int l=0;l<n;l++) {
            int r = l+1;
            while(r < n && prices[l] < prices[r]) {
                profit = Math.max(profit, prices[r]-prices[l]);
                r++;
            }

            l = r-1;
        }

        return profit;
    }
}
