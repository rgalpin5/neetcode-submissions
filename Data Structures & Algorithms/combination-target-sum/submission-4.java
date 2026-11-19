class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        backtrack(0, target, current, nums, ans);
        return ans;
    }

    public void backtrack(int index, int remaining, ArrayList<Integer> current, int[] nums, List<List<Integer>> ans) {
        if (index >= nums.length) return;
        else if(remaining - nums[index] == 0) {
            current.add(nums[index]);
            ans.add(List.copyOf(current));
            current.remove(current.size() - 1);
            backtrack(index + 1, remaining, current, nums, ans);
        }
        else if(remaining - nums[index] > 0) {
            current.add(nums[index]);
            backtrack(index, remaining - nums[index], current, nums, ans);
            current.remove(current.size() - 1);
            backtrack(index + 1, remaining, current, nums, ans);
        }
        else {
            backtrack(index + 1, remaining, current, nums, ans);            
        }
    }
}


