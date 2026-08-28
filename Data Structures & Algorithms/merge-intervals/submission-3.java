class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i < intervals.length; i++) {
            if(res.isEmpty() || res.get(res.size() - 1)[1] < intervals[i][0]) {
                res.add(intervals[i]);
            }
            else {
                int[] newInterval = new int[2];
                newInterval[0] = Math.min(res.get(res.size() - 1)[0], intervals[i][0]);
                newInterval[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);
                res.set(res.size() - 1, newInterval);
            }
        }

        return res.toArray(new int[0][]);
    }
}
