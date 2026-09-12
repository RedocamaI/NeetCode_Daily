class Solution {
    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n][m];

        // fill the last row:
        Arrays.fill(dp[n-1], 1);
        // fill the last column:
        for(int i=0;i<n-1;i++) {
            dp[i][m-1] = 1;
        }

        for(int i=n-2;i>=0;i--) {
            for(int j=m-2;j>=0;j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }
}
