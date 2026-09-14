class Solution {
    int[][] dp;
    private int getLcsLength(int i, int j, String text1, String text2) {
        if(i == text1.length() || j == text2.length())
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int l = 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            l = 1 + getLcsLength(i+1, j+1, text1, text2);
            return dp[i][j] = l;
        }

        int x = getLcsLength(i, j+1, text1, text2);
        int y = getLcsLength(i+1, j, text1, text2);
        int z = getLcsLength(i+1, j+1, text1, text2);

        return dp[i][j] = Math.max(x, Math.max(x, y));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        dp = new int[n][m];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }

        return getLcsLength(0, 0, text1, text2);
    }
}
