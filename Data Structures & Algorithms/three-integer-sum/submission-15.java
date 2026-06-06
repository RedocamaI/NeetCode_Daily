class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            int target = -1*nums[i];
            int l = i+1, h = n-1;
            while(l < h) {
                int sum = nums[l] + nums[h];
                if(sum > target) {
                    h--;
                }else if(sum < target) {
                    l++;
                }else {
                    ans.add(new ArrayList<>(List.of(nums[i], nums[l], nums[h])));

                    l++;
                    h--;

                    while(l < n && (h+1) < n && 
                    nums[l-1] == nums[l] &&
                    nums[h+1] == nums[h]) {
                        l++;
                        h--;
                    }
                }
            }
        }

        return ans;
    }
}
