class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastReachableIndex = n-1;

        for(int i=n-2;i>=0;i--) {
            int distance = nums[i];
            if(distance >= (lastReachableIndex-i)) {
                lastReachableIndex = i;
            }
        }

        return lastReachableIndex == 0;
    }
}
