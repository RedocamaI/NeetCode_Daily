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
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for(Interval interval : intervals) {
            starts.add(interval.start);
            ends.add(interval.end);
        }

        Collections.sort(starts);
        Collections.sort(ends);
        int s = 0, e = 0;
        int n = starts.size();
        int count = 0, ans = 0;

        while(s < n && e < n) {
            if(starts.get(s) < ends.get(e)) {
                count++;
                s++;
                ans = Math.max(ans, count);
                continue;
            }

            count--;
            e++;
        }

        return ans;
    }
}
