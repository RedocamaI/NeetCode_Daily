class Solution {
    protected int isOverlapping(int[] interval1, int[] interval2) {
        if(interval1[1] < interval2[0])
            return -1;
        
        if(interval1[0] > interval2[1])
            return 1;
        
        return 0;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;

        ans.add(newInterval);
        for(int i=0;i<n;i++) {
            int[] lastInterval = ans.get(ans.size()-1);
            int[] currInterval = intervals[i];
            ans.remove(ans.size()-1);

            int status = isOverlapping(lastInterval, currInterval);
            
            if(status == 0) {
                int x = Math.min(lastInterval[0], currInterval[0]);
                int y = Math.max(lastInterval[1], currInterval[1]);

                ans.add(new int[]{x, y});
                continue;
            }else if(status < 0) {
                ans.add(lastInterval);
                ans.add(currInterval);
                continue;
            }

            ans.add(currInterval);
            ans.add(lastInterval);
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
