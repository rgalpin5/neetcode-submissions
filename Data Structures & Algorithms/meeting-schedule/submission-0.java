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
        Interval[] times = new Interval[intervals.size()];
        int idx = 0;
        for(Interval interv : intervals) {
            times[idx++] = interv;
        }

        Arrays.sort(times, Comparator.comparingInt(a -> (a.start)));

        for(int i = 0; i < times.length - 1; i++) {
            if(times[i].end > times[i+1].start) return false;
        }
        return true;
    }
}
