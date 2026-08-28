class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start){
        if(remain == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        else if(remain < 0 || start >= nums.length) return;
        for(int i = start; i < nums.length; i++){
            System.out.println(tempList);
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i);
            tempList.remove(tempList.size()-1);
        }
    }
}
