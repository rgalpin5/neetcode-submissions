class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        if(nums[0] == 0) return false;
        int maxSoFar = nums[0];

        for(int i = 0; i < nums.length - 1; i++) {
            if(i > maxSoFar) return false;
            maxSoFar = Math.max(maxSoFar, i + nums[i]);
            
            if(maxSoFar >= nums.length - 1) return true;
        }

        return false;
    }
}
