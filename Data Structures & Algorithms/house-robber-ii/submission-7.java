class Solution {
    public int rob(int[] nums) {   
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i-2] + nums[i], dp1[i-1]);
        }
        dp2[nums.length - 1] = nums[nums.length - 1];
        dp2[nums.length - 2] = Math.max(nums[nums.length - 2], nums[nums.length - 1]);
        for(int j = nums.length - 3; j > 0; j--) {
            dp2[j] = Math.max(dp2[j + 2] + nums[j], dp2[j+1]);
        }

        return Math.max(dp1[nums.length - 2], dp2[1]);
    }
}
