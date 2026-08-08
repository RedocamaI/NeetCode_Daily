class Solution {
    List<List<Integer>> subsets;
    List<Integer> subset;

    private void getSubsets(int ind, int n, int[] nums) {
        subsets.add(new ArrayList<>(subset));

        for(int i=ind;i<n;i++) {
            if(i > ind && nums[i] == nums[i-1])
                continue;
            
            // take:
            subset.add(nums[i]);
            getSubsets(i+1, n, nums);

            // backtrack:
            subset.remove(subset.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        this.subsets = new ArrayList<>();
        this.subset = new ArrayList<>();
        getSubsets(0, n, nums);

        return this.subsets;
    }
}
