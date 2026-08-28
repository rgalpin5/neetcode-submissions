class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 1) {
            if(nums[0] == 1) return 2;
            return 1;
        }
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            if(currNum < nums.length && currNum >= 0) {
                temp = nums[currNum];
                nums[currNum] = currNum;
                nums[i] = temp;
            }
        }
        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            if(currNum < nums.length && currNum >= 0) {
                temp = nums[currNum];
                nums[currNum] = currNum;
                nums[i] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
        int idx = 1;
        while(idx < nums.length) {
            if(nums[idx] != idx && nums[0] != idx) return idx;
            idx++;
        }
        if(nums[0] == idx || nums[nums.length-1] == idx) return idx+1;
        return idx;
    }

    
}