class Solution {
    private StringBuffer longestPal;
    int[][] dp;

    private boolean isPal(String s, int i, int j) {
        while(i <= j) {
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }

        return true;
    }

    private int getLongestPal(String s, int i, int j) {
        if(i > j)
            return -1;

        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(isPal(s, i, j)) {
            if(longestPal.length() < j-i+1) {
                // clear the buffer:
                longestPal.setLength(0);

                // append new string:
                longestPal.append(s.substring(i, j+1));
            }

            return dp[i][j] = j-i+1;
        }

        dp[i+1][j] = getLongestPal(s, i+1, j);
        dp[i][j-1] = getLongestPal(s, i, j-1);
        dp[i+1][j-1] = getLongestPal(s, i+1, j-1);

        return dp[i][j] = Math.max(dp[i+1][j], 
            Math.max(dp[i][j-1], dp[i+1][j-1]));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1)
            return s;
        
        this.dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        longestPal = new StringBuffer("");
        getLongestPal(s, 0, n-1);

        return this.longestPal.toString();
    }
}
