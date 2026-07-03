class Solution {
    protected int isOverlapping(int[] interval1, int[] interval2) {
        if(interval1[1] < interval2[0])
            return -1;
        
        if(interval1[0] > interval2[1])
            return 1;
        
        return 0;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        
        list.add(newInterval);
        for(int i=0;i<n;i++) {
            int[] lastInterval = list.get(list.size()-1);
            int[] currInterval = intervals[i];
            list.remove(list.size()-1);

            int status = isOverlapping(lastInterval, currInterval);
            if(status == 0) {
                int x = Math.min(lastInterval[0], currInterval[0]);
                int y = Math.max(lastInterval[1], currInterval[1]);

                list.add(new int[]{x, y});
                continue;
            }else if(status < 0) {
                list.add(lastInterval);
                list.add(currInterval);
                continue;
            }

            list.add(currInterval);
            list.add(lastInterval);
        }

        return list.toArray(new int[list.size()][]);
    }
}
