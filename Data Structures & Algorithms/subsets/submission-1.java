class Solution {
    int[] nums;
    List<Integer> subset;
    List<List<Integer>> ans;

    void getSubsets(int ind, int l) {
        if(ind == l) {
            // creating a shallow copy; since java passes objects
            // by reference and we are eventually emptying the
            // subset array in backtrack step. so directly adding
            // subset would result in empty array for each add.
            this.ans.add(new ArrayList<>(this.subset));
            return;
        }

        // take:
        this.subset.add(nums[ind]);
        getSubsets(ind+1, l);

        // not take: backtrack
        this.subset.remove(this.subset.size()-1);
        getSubsets(ind+1, l);
    }
    public List<List<Integer>> subsets(int[] nums) {
        this.ans = new ArrayList<>();
        this.subset = new ArrayList<>();
        this.nums = nums;

        getSubsets(0, nums.length);
        return this.ans;
    }
}
