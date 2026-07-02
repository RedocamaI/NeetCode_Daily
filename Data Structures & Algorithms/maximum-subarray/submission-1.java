class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int sum = nums[0];

        for(int i=1;i<n;i++) {
            sum += nums[i];
            if(sum < nums[i] || sum < 0) {
                sum = nums[i];
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
