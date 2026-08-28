class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        /*
        [1,2,3,4,5,6]
        target == 8
        l = 0
        r = 5
        m = 2
        */
        while(l < r) {
            if(numbers[l] + numbers[r] == target) {
                return new int[]{l+1, r+1};
            }
            else if(numbers[l] + numbers[r] > target) {
                r--;
            }
            else{
                l++;
            }
        }
        return new int[]{l + 1, r + 1};
    }
}
