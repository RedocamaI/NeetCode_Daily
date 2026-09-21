class Solution {
    private int[][] dp;
    private int getMinDist(int i, int j, String word1, String word2) {
        if(i == word1.length())
            return word2.length() - j;
        if(j == word2.length())
            return word1.length() - i;
        
        if(dp[i][j] != -1)
            return dp[i][j];

        char a = word1.charAt(i);
        char b = word2.charAt(j);

        if(a == b)
            return dp[i][j] = getMinDist(i+1, j+1, word1, word2);
        
        int delete = 1 + getMinDist(i+1, j, word1, word2);
        int replace = 1 + getMinDist(i+1, j+1, word1, word2);
        
        return dp[i][j] = Math.min(delete, replace);
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if(n < m)
            return minDistance(word2, word1);
        
        this.dp = new int[n][m];
        for(int i=0;i<n;i++) {
            Arrays.fill(this.dp[i], -1);
        }

        return getMinDist(0, 0, word1, word2);
    }
}
