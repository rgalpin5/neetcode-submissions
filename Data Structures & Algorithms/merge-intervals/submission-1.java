class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> intervalList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> (a[0])));
        for(int i = 0; i < intervals.length-1; i++) {
            if(intervals[i+1][0] <= intervals[i][1]) {
                intervals[i+1][0] = Math.min(intervals[i][0], intervals[i+1][0]);
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
            }
            else {
                intervalList.add(intervals[i]);
            }
        }
        if(!intervalList.contains(intervals[intervals.length-1])) {
            intervalList.add(intervals[intervals.length-1]);
        }
        int[][] ans = new int[intervalList.size()][2];
        int i = 0;
        for(int[] interval : intervalList) {
            ans[i] = interval;
            i++;
        }

        return ans;
    }
}
