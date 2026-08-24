class Solution {
    private int[] dp;

    private int getWays(int i, String s) {
        if(i == s.length())
            return 1;
        if(dp[i] != -1)
            return dp[i];
        
        int ways = 0;
        int val = s.charAt(i) - '0';

        // take the current charatcter only:
        if(val != 0) {
            ways += getWays(i+1, s);
        }

        // take 2 characters:
        if(i < s.length()-1 && val != 0) {
            int nextVal = s.charAt(i+1) - '0';

            if(val < 2)
                ways += getWays(i+2, s);
            else if(val == 2 && nextVal <= 6)
                ways += getWays(i+2, s);
        }

        return dp[i] = ways;
    }
    public int numDecodings(String s) {
        if(s.charAt(0)-'0' == 0)
            return 0;
        
        int n = s.length();
        this.dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = getWays(0, s);

        for(int i=0;i<n;i++) {
            System.out.println("i: " + dp[i]);
        }

        return ans;
    }
}
