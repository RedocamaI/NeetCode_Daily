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

    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1)
            return s;
        
        this.dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        longestPal = new StringBuffer("");

        for(int j=n-1;j>=0;j--) {
            for(int i=n-1;i>=0;i--) {
                if(isPal(s, i, j)) {
                    if(longestPal.length() < j-i+1) {
                        longestPal.setLength(0);
                        longestPal.append(s.substring(i, j+1));
                    }

                    dp[i][j] = j-i+1;
                    continue;
                }

                int val = -1;
                if(i < n-1) {
                    val = Math.max(val, dp[i+1][j]);
                }
                if(j > 0) {
                    val = Math.max(val, dp[i][j-1]);
                }
                if(i < n-1 && j > 0) {
                    val = Math.max(val, dp[i+1][j-1]);
                }

                dp[i][j] = val;
            }
        }

        return this.longestPal.toString();
    }
}
