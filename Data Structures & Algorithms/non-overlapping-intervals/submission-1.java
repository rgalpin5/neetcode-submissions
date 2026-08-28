class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int prevEnd = intervals[0][1];
        int removals = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < prevEnd) {
                prevEnd = Math.min(prevEnd, intervals[i][1]);
                removals++;
            }
            else{
                prevEnd = intervals[i][1];
            }
        }
        return removals;
    }
}
