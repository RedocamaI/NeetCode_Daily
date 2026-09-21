class Solution {
    private int[][] dp;

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if(n < m)
            return minDistance(word2, word1);
        
        this.dp = new int[n+1][m+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(this.dp[i], -1);
        }

        // base case:
        for(int i=0;i<=n;i++) {
            dp[i][m] = n - i;
        }
        for(int j=0;j<=m;j++) {
            dp[n][j] = m - j;
        }

        for(int i=n-1;i>=0;i--) {
            for(int j=m-1;j>=0;j--) {
                char a = word1.charAt(i);
                char b = word2.charAt(j);
                int rep = dp[i+1][j+1];

                if(a == b) {
                    dp[i][j] = rep;
                    continue;
                }

                int delete = 1 + dp[i+1][j];
                int replace = 1 + rep;

                dp[i][j] = Math.min(delete, replace);
            }
        }

        return dp[0][0];
    }
}
