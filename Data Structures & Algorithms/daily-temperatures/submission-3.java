class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            int[] currDay = new int[]{temperatures[i], i};
            while(!stack.isEmpty() && stack.peek()[0] < currDay[0]) {
                int[] pastDay = stack.pop();
                ans[pastDay[1]] = i - pastDay[1];
            }
            stack.push(currDay);
        }

        return ans;
    }
}
