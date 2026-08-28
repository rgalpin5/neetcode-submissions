class Solution {
    public int maxProduct(int[] nums) {
        Set<Integer> dp = new HashSet<>();
        Set<Integer> storage = new HashSet<>();
        dp.add(1);
        if(nums.length == 1){
            return nums[0];
        }
        for(int num : nums){

            Set<Integer> tempDP = new HashSet<>();
            for(Integer p : dp){                
                tempDP.add(num*p);
                tempDP.add(num);
            }
            //System.out.println(tempDP);

            dp = tempDP;
            storage.addAll(dp);
            
        }
        int max = 0;
        System.out.println(storage);
        for(Integer val : storage){
            max = Math.max(val, max);
        }
        return max;
    }
}
