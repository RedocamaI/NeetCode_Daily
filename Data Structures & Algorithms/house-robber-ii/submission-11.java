class Solution {
    int getMaxMoney(List<Integer> nums) {
        int n = nums.size();
        if(n == 1)
            return nums.get(0);
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[n-1] = nums.get(n-1);
        dp[n-2] = Math.max(nums.get(n-2), nums.get(n-1));
        for(int i=n-3;i>=0;i--) {
            dp[i] = Math.max(nums.get(i) + dp[i+2], dp[i+1]);
        }

        return Math.max(dp[0], dp[1]);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++) {
            arr.add(nums[i]);
        }

        int last = arr.get(n-1);

        arr.remove(n-1);
        int max1 = getMaxMoney(arr);

        arr.add(last);
        arr.remove(0);
        int max2 = getMaxMoney(arr);

        return Math.max(max1, max2);
    }
}
