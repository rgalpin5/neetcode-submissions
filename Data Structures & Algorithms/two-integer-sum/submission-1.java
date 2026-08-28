class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i<nums.length;i++){
            int complement = target - nums[i];
            if(complements.containsKey(complement)){
                ans[0] = complements.get(complement);
                ans[1] = i;
                return ans;
            }
            complements.put(nums[i], i);

        }
        return ans;
        
    }
}
