class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int ans = nums[n-1];
        int mx = nums[n-1];
        int mn = nums[n-1];

        for(int i=n-2;i>=0;i--) {
            int val = Math.max(nums[i],Math.max(nums[i]*mx, nums[i]*mn));

            ans = Math.max(ans, val);

            int temp = mx;
            mx = Math.max(nums[i], Math.max(nums[i]*mx, nums[i]*mn));
            mn = Math.min(nums[i], Math.min(nums[i]*temp, nums[i]*mn));
        }

        return ans;
    }
}
