class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(Integer num:nums) {
            if(mp.containsKey(num))
                return true;
            mp.put(num, 1);
        }

        return false;
    }
}