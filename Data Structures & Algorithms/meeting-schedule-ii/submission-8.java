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
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

        for(int i = 0; i < intervals.size(); i++) {
            Interval currInterval = intervals.get(i);
            if(heap.isEmpty()) {
                heap.offer(currInterval);
            }
            else {
                if(currInterval.start >= heap.peek().end) {
                    heap.poll();
                }
                heap.offer(currInterval);
            }
        }

        return heap.size();
    }
}
