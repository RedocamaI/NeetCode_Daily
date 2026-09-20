class Solution {
    int[][] dp;

    boolean isPos(int x, int y, String s1, String s2, String s3) {
        if(x+y == s3.length())
            return x == s1.length() && y == s2.length();
        
        if(dp[x][y] != -1)
            return (dp[x][y] == 1);

        int c = s3.charAt(x+y);

        boolean path1 = false;
        if(x < s1.length() && s1.charAt(x) == c) {
            path1 = isPos(x+1, y, s1, s2, s3);
        }

        boolean path2 = false;
        if(y < s2.length() && s2.charAt(y) == c) {
            path2 = isPos(x, y+1, s1, s2, s3);
        }

        boolean isPos = path1 || path2;
        dp[x][y] = isPos ? 1 : 0;
        
        return isPos;
    } 

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();

        if(n + m != k)
            return false;

        this.dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            Arrays.fill(dp[i], -1);
        }

        return isPos(0, 0, s1, s2, s3);
    }
}
