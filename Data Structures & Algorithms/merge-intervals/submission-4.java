class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int index = 0;

        while(index < intervals.length) {
            int currLow = intervals[index][0];
            int currHigh = intervals[index][1];
            index++;
            while(index < intervals.length) {
                if(intervals[index][0] <= currHigh) {
                    currHigh = Math.max(currHigh, intervals[index][1]);
                    index++;
                }
                else break;
            }
            int[] currInterval = new int[]{currLow, currHigh};
            merged.add(currInterval);
        }

        int[][] ans = new int[merged.size()][2];
        int i = 0;
        for(int[] interval : merged) {
            ans[i++] = interval;
        }
        return ans;
    }
}
