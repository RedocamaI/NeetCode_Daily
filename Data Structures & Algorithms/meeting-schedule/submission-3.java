/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Comparator<Interval> compIntervals = new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if(a.start == b.start)
                    return a.end = b.end;
                
                return a.start - b.start;
            }
        };

        Collections.sort(intervals, compIntervals);
        int n = intervals.size();
        for(int i=1;i<n;i++) {
            int prevEnd = intervals.get(i-1).end;
            int currStart = intervals.get(i).start;

            if(prevEnd > currStart)
                return false;
        }

        return true;
    }
}
