class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int[] jumps = new int[n];
        jumps[n-1] = 0;
        for(int i=n-2;i>=0;i--) {
            int jump = nums[i];
            if(jump == 0)
                continue;
            
            int totalJumps = Integer.MAX_VALUE;
            for(int j=jump;j>=1;j--) {
                int newInd = i + j;
                if(newInd >= n)
                    continue;
                if(newInd != n-1 && jumps[newInd] == 0)
                    continue;
                
                totalJumps = Math.min(totalJumps, 1 + jumps[j + i]);
            }

            jumps[i] = totalJumps;
        }

        return jumps[0];
    }
}
