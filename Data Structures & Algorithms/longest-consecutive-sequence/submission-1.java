class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        if(nums.length == 0){
            return 0;
        }
        for(int num:nums){
            numSet.add(num);
        }
        int tempSeq = 1;
        int longSeq = 1;
        int i = 1;
        for(int num:nums){
            while(numSet.contains(num + i++)){
                tempSeq++;
            }
            longSeq = Math.max(longSeq, tempSeq);
            tempSeq = 1;
            i = 1;
        }
        return longSeq;
    }
}
