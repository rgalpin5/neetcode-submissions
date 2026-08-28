class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> threeSum(int[] nums) {
        ans = new ArrayList<>();

        for(int i = 0; i < nums.length-2; i++) {
            twoSum(nums, i+1, nums[i]);
        }

        return ans;
    }

    private void twoSum(int[] nums, int i, int target) {
        HashSet<Integer> complements = new HashSet<>();
        List<Integer> threeSum = new ArrayList<>();
        /*
        [-1,0,1,2,-1,-4]
        complements = {0}
        target = -1
        complement = 0
        nums[i] = 1
        i = 2
        ans = {{-1,0,1}}
        */
        while(i < nums.length){
            int complement = -(nums[i] + target);
            if(complements.contains(complement)) {
                threeSum.add(target);
                threeSum.add(nums[i]);
                threeSum.add(complement);
                Collections.sort(threeSum);
                if(!ans.contains(threeSum)){
                    ans.add(threeSum);
                }
                threeSum = new ArrayList<>();
            }
            complements.add(nums[i]);
            i++;
        }
    }
}
