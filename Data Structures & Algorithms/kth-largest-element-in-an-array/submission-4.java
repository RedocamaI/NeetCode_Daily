class Solution {
    public int getPosition(int val, int[] nums) {
        int x = 1;
        for(int i=0;i<nums.length;i++) {
            if(val < nums[i])
                x++;
        }

        return x;
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int h = Integer.MIN_VALUE;
        int l = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {
            l = Math.min(nums[i], l);
            h = Math.max(nums[i], h);
        }

        int ans = -1;
        while(l <= h) {
            int mid = l + (h-l)/2;
            int x = getPosition(mid, nums);
            
            if(x > k) {
                l = mid+1;
            }else {
                ans = mid;
                h = mid-1;
            }
        }

        return ans;
    }
}
