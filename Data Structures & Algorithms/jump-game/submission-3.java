class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];

        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            int jumps = nums[i];

            if(dp[i]){
                for(int j = 0; i + j <  dp.length && j <= jumps; j++){
                    
                    dp[i+j] = true;
                }
            }
        }

        return dp[nums.length-1];


    }
}
