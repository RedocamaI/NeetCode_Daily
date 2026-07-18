class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (row1, row2) ->
            Integer.compare(row1[0], row2[0]));

        int end = intervals[0][1];
        int ans = 0;
        for(int i=1;i<n;i++) {
            if(end > intervals[i][0]) {
                ans++;
                end = Math.min(end, intervals[i][1]);
            }else {
                end = intervals[i][1];
            }
        }

        return ans;
    }
}
