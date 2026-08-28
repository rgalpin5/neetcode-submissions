class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int totalProduct = 1;
        boolean containsZero = false;
        boolean containsTwoZeroes = false;
        for(int num : nums) {
            if(num == 0){
                if(containsZero) containsTwoZeroes = true;
                containsZero = true;
            }
            else{
                totalProduct *= num;
            }
        }
        if(containsTwoZeroes) return ans;
        for(int i = 0; i < nums.length; i++) {
            if(containsZero) {
                if(nums[i] == 0) ans[i] = totalProduct;
            }
            else{
                ans[i] = totalProduct / nums[i];
            }
        }

        return ans;
    }
}  
