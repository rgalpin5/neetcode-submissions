class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        if(nums.length == 0) return 0;
        int minNum = nums[0];
        int maxNum = nums[0];
        for(int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
            numSet.add(num);
        }
        int maxSeq = 1;
        for(int num : numSet) {
            int next = 1;
            while(numSet.contains(num+next)){
                maxSeq = Math.max(next + 1, maxSeq);
                next++;
            }
        }
        return maxSeq;
    }
}
