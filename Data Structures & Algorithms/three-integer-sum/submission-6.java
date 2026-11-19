class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i ++) {
            int left = i + 1;
            int right = nums.length - 1;
            // [-4, -1, -1, 0, 1, 2] with i = 0
            while(right > left) {
                if(-(nums[right] + nums[left]) == nums[i]) {
                    if(!ans.contains(List.of(nums[i], nums[right], nums[left]))){
                        ans.add(new ArrayList<>(List.of(nums[i], nums[right], nums[left])));
                    }
                    left++;
                    right--;
                }
                else if(-(nums[right] + nums[left]) > nums[i]) {
                    left++;
                }
                else right--;
            }
        }
        return ans;
    }
}
