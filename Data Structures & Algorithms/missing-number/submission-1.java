class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int val = n;
        for(int i=0;i<n;i++) {
            val ^= nums[i];
        }

        for(int i=1;i<n;i++) {
            val ^= i;
        }

        return val;
    }
}
