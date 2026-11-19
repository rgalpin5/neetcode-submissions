class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int inverse = target - num;
            if(seen.containsKey(inverse)) {
                return new int[]{seen.get(inverse), i};
            }
            seen.put(num, i);
        }

        return new int[]{0, 1};
    }
}
