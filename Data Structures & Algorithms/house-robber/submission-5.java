class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[2] + dp[0], dp[1]);
        for(int i = 3;i<nums.length;i++){
            dp[i] = Math.max(dp[i-3] + nums[i], Math.max(nums[i] + dp[i-2], dp[i-1]));
        }

        /* 
        Input: nums = [5,1,2,10,6,2,7,9,3,1]
               dp   = [5,1,7,11,13,13,20,21,23,23]


        */
        return dp[nums.length-1];


    }
}
