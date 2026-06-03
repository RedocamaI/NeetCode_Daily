class Solution {
    List<Integer> dp;
    
    int getWays(int n) {
        if(n < 0)
            return 0;

        if(n == 0) {
            return 1;
        }

        if(dp.get(n) != -1)
            return dp.get(n);
        
        // way 1 - take 1 step:
        int way1 = getWays(n-1);

        // way 2 - take 2 steps:
        int way2 = getWays(n-2);

        dp.set(n, way1 + way2);
        return dp.get(n);
    }
    public int climbStairs(int n) {
        this.dp = new ArrayList<>(Collections.nCopies(n+1, -1));
        
        return getWays(n);
    }
}
