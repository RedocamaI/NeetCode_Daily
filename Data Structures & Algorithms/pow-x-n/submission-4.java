class Solution {
    Map<String, Double> dp;

    private double getPow(double x, long n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        
        String pow = String.valueOf(Math.abs(n));
        if(n < 0){
            if(dp.containsKey(pow))
                return dp.get(pow);

            double result = 1/(double)(getPow(x, -1*n));
            dp.put(pow, result);

            return result;
        }

        if(dp.containsKey(pow))
            return dp.get(pow);

        if(n%2 == 1){
            double result = getPow(x, n/2) * getPow(x, n/2+1);
            dp.put(pow, result);

            return result;
        }
        
        double result = getPow(x, n/2) * getPow(x, n/2);
        dp.put(pow, result);

        return result;
    }

    public double myPow(double x, int n) {
        dp = new HashMap<>();

        return getPow(x, (long)n);
    }
}
