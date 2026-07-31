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
        intervals.sort((a, b) -> {
            if(a.start != b.start)
                return Integer.compare(a.start, b.start);
            
            return Integer.compare(a.end, b.end);
        });
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(
            (a, b) -> {
                return Integer.compare(a.end, b.end);
            }
        );

        for(Interval interval : intervals) {
            if(minHeap.isEmpty()) {
                minHeap.offer(interval);
                continue;
            }

            if(minHeap.peek().end <= interval.start) {
                minHeap.poll();
            }

            minHeap.offer(interval);
        }

        return minHeap.size();
    }
}
