class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, target, current, ans, 0);
        return ans;
    }

    public void backtrack(int[] nums, int remaining, List<Integer> current, List<List<Integer>> ans, int index) {
        if(index >= nums.length) return;
        if(remaining - nums[index] == 0) {
            current.add(nums[index]);
            ans.add(List.copyOf(current));
            current.remove(current.size() - 1);
        }
        else if(remaining - nums[index] > 0) {
            current.add(nums[index]);
            backtrack(nums, remaining - nums[index], current, ans, index);
            current.remove(current.size() - 1);
        }
        backtrack(nums, remaining, current, ans, index + 1);
    }
}
