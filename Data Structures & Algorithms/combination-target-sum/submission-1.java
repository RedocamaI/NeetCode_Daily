class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> combo = new ArrayList<>();
    public void getCombos(int[] nums, int ind, int target) {
        if(ind == nums.length) {
            if(target > 0)
                return;
            
            List<Integer> finalCombo = new ArrayList<>(combo);
            ans.add(finalCombo);
            return;
        }

        // take:
        if(nums[ind] <= target) {
            combo.add(nums[ind]);
            getCombos(nums, ind, target-nums[ind]);
            combo.remove(combo.size()-1);
        }

        // not take:
        getCombos(nums, ind+1, target);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        getCombos(nums, 0, target);

        return this.ans;
    }
}
