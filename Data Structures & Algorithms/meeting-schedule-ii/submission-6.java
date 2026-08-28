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
        int[] startArr = new int[intervals.size()];
        int[] endArr = new int[intervals.size()];
        int idx = 0;
        for(Interval ival : intervals) {
            startArr[idx] = ival.start;
            endArr[idx] = ival.end;
            idx++;
        }

        Arrays.sort(startArr);
        Arrays.sort(endArr);

        int start = 0;
        int end = 0;
        int count = 0;
        int maxCount = 0;

        while(start < intervals.size()) {
            if(startArr[start] < endArr[end]) {
                count++;
                start++;
            }
            else{
                end++;
                count--;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
