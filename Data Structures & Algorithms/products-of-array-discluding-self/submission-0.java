class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] products = new int[nums.length];
        boolean includesZero = false;
        boolean twoZeros = false;
        for(int num: nums){
            if(num == 0){
                if(includesZero){
                    return products;
                }
                includesZero = true;
                
            }
            else{
                product *= num; 
            }
            
        }

        for(int i = 0; i<nums.length;i++){
            if(includesZero){
                if(nums[i] == 0){
                    products[i] = product;
                }
            }
            else{
                    products[i] = product/nums[i];
            } 
        }          
        return products;
    }
}  
