class Solution {
    public int missingNumber(int[] nums) {

        int xOr = nums.length;
        for(int i = 0; i < nums.length; i++){
            xOr ^= nums[i] ^ i;
        }

        

        

        return xOr;
        
    }
}
