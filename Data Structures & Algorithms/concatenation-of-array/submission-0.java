class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] concatArray = new int[nums.length *2];
        for(int i = 0;i<nums.length;i++){
            concatArray[i] = nums[i];
            concatArray[nums.length+i] = nums[i];
        }
        return concatArray;
    }
}