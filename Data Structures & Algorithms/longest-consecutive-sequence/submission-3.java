class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        if(nums.length == 0) return 0;
        HashSet<Integer> numSet = new HashSet<>();

        for(int num : nums){
            numSet.add(num);
        }
        int temp;
        for(int num : nums){
            temp = 0;
            while(numSet.contains(num + temp)){
                temp++;
            }
            longest = Math.max(temp, longest);
        }
        return longest;
    }
}
