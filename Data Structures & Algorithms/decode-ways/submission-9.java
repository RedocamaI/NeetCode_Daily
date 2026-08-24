class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[n] = 1;
        for(int i=n-1;i>=0;i--) {
            int val = s.charAt(i) - '0';
            if(val == 0){
                dp[i] = 0;
                continue;
            }

            int take1 = dp[i+1];
            int take2 = 0;
            if(i <= n-2) {
                int nextVal = s.charAt(i+1) - '0';

                if(val == 1 || (
                    (val == 2 && nextVal < 7))
                )
                    take2 = dp[i+2];
            }

            dp[i] = take1 + take2;
        }

        return dp[0];
    }
}
