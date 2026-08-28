class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>();
        int idx = 0;
        
        while(idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            intervalList.add(intervals[idx]);
            idx++;
        }

       
        while(idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }

        intervalList.add(newInterval);
        while(idx < intervals.length) {
            intervalList.add(intervals[idx]);
            idx++;
        }

        return intervalList.toArray(new int[intervalList.size()][]);
        
    }
}
