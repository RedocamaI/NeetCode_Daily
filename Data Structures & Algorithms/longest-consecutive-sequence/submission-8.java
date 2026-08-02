class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }

        int start = 0;
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(!map.containsKey(nums[i]-1)) {
                start = nums[i];
            }else   continue;

            int curr = start + 1;
            int len = 1;
            while(map.containsKey(curr)) {
                curr++;
                len++;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}
