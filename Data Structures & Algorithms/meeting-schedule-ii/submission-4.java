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
        int[] startTimes = new int[intervals.size()];
        int[] endTimes = new int[intervals.size()];
        int idx = 0;
        if(intervals.size() == 0) return 0;

        for(Interval ival : intervals) {
            startTimes[idx] = ival.start;
            endTimes[idx++] = ival.end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int count = 1;
        int maxCount = 1;

        int s = 1;
        int e = 0;

        while(e < endTimes.length && s < endTimes.length) {
            if(startTimes[s] < endTimes[e]) {
                s++;
                count++;
                maxCount = Math.max(count, maxCount);
            }
            else {
                e++;
                count--;
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
        
    }
}
