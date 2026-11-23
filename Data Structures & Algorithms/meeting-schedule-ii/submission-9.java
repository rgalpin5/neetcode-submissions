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
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < intervals.size(); i++) {
            Interval currInterval = intervals.get(i);
            if(minHeap.isEmpty()) {
                minHeap.offer(currInterval.end);
            }
            else {
                if(currInterval.start >= minHeap.peek()) {
                    minHeap.poll();
                }
                minHeap.offer(currInterval.end);
            }
        }
        return minHeap.size();
    }
}
