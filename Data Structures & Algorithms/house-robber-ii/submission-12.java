class Solution {
    int getMaxMoney(List<Integer> nums) {
        int n = nums.size();
        if(n == 1)
            return nums.get(0);

        int prev = nums.get(n-1);
        int cur = Math.max(nums.get(n-2), nums.get(n-1));
        for(int i=n-3;i>=0;i--) {
            int next = Math.max(nums.get(i) + prev, cur);
            prev = cur;
            cur = next;
        }

        return Math.max(cur, prev);
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
