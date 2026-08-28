class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> uniqueNums = new HashMap<>();

        for(int i = 0; i<nums.length;i++){
            if(uniqueNums.containsValue(nums[i])){
                return true;
            }
            uniqueNums.put(i, nums[i]);
        }
        return false;
    }
}