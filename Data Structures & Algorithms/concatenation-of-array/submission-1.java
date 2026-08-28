class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] concatArr = new int[n*2];
        int i = 0;
        for(int num:nums){
            concatArr[i] = num;
            concatArr[i+n] = num;
            i++;
        }
        return concatArr;
    }
}