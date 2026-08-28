class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();
        int[] indices = new int[2];
        int complement;
        for(int i = 0;i<nums.length;i++){
            complement = target - nums[i];
            if(complements.containsKey(complement)){
                indices[0] = complements.get(complement);
                indices[1] = i;
                return indices;
            }
            complements.put(nums[i], i);
            
        }
        return indices;
    }
}
