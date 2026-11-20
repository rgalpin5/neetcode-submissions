class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int num : dp) {
            max = Math.max(max, num);
        }

        return max;
    }
}
