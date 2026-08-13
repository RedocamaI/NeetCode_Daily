class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++) {
            int val = nums[Math.abs(nums[i]) - 1];
            if(val < 0)
                return Math.abs(nums[i]);
            
            nums[Math.abs(nums[i]) - 1] *= -1;
        }

        return -1;
    }
}
