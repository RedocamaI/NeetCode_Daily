class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n-1;

        if(nums[l] < nums[h])
            return nums[l];

        int minEl = Integer.MAX_VALUE;
        while(l <= h) {
            int mid = l + (h-l)/2;

            if(nums[l] <= nums[mid]) {
                minEl = Math.min(minEl, nums[l]);
                l = mid+1;
            }else {
                minEl = Math.min(minEl, nums[mid]);
                h = mid-1;
            }
        }

        return minEl;
    }
}
