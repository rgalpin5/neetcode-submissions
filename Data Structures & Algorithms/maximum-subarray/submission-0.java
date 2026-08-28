class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0];
        int maxSum = nums[0];
        //[2,-3,4,-2,2,1,-1,4]
        //cur = 5
        //max = 5
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > curSum + nums[i]){
                curSum = nums[i];
            }
            else{
                curSum += nums[i];
            }


            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
