class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if(nums.length == 0) return 0;

        for(int num : nums) {
            set.add(num);
        }

        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i] - 1)) {
                boolean isValid = true;
                int count = 1;
                int num = nums[i];
                while(set.contains(num + 1)) {
                    count++;
                    num++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}
