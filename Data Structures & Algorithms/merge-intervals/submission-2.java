class Solution {
    boolean isOverlapping(int[] a, int[] b) {
        if(a[1] < b[0] || a[0] > b[1])
            return false;
        
        return true;
    }
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }else {
                return Integer.compare(a[1], b[1]);
            }
        });

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for(int i=1;i<n;i++) {
            int[] interval = merged.get(merged.size()-1);
            merged.remove(merged.size()-1);

            if(isOverlapping(interval, intervals[i])) {
                int x = Math.min(interval[0], intervals[i][0]);
                int y = Math.max(interval[1], intervals[i][1]);

                merged.add(new int[]{x, y});
                continue;
            }

            merged.add(interval);
            merged.add(intervals[i]);
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
