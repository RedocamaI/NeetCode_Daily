class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> nums = new ArrayList<>();
        for(int val:digits) {
            nums.add(val);
        }
        Collections.reverse(nums);

        int carry = 1;
        int n = nums.size();
        for(int i=0;i<n;i++) {
            int val = nums.get(i);
            val += carry;
            if(val > 9) {
                carry = 1;
                val = 0;
            } else {
                carry = 0;
            }
            nums.set(i, val);
        }

        if(nums.get(n-1) == 0) {
            nums.add(carry);
        }

        Collections.reverse(nums);
        n = nums.size();
        int[] ans = new int[n];
        for(int i=0;i<n;i++) {
            ans[i] = nums.get(i);
        }

        return ans;
    }
}
