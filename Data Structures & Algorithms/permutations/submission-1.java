class Solution {
    List<List<Integer>> ans;

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void permute(int[] nums, int i, int n) {
        if(i == n) {
            ans.add(Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors
                    .toCollection(ArrayList::new))
            );
            return;
        }

        for(int j=i;j<n;j++) {
            swap(nums, i, j);
            permute(nums, i+1, n);
            swap(nums, i, j);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.ans = new ArrayList<>();
        int n = nums.length;

        for(int j=0;j<n;j++) {
            swap(nums, 0, j);
            permute(nums, 1, n);
            swap(nums, 0, j);
        }

        return this.ans;
    }
}
