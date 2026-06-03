class Solution {
    List<Integer> dp;
    
    public int climbStairs(int n) {
        this.dp = new ArrayList<>(Collections.nCopies(n+1, -1));

        dp.set(0, 1);
        dp.set(1, 1);
        for(int i=2;i<=n;i++) {
            dp.set(i, dp.get(i-1) + dp.get(i-2));
        }

        return dp.get(n);
    }
}
