class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int m;

        while(l<r){
            m = l + (r-l) / 2;
            if(nums[m] == target) return m;
            if(nums[m] >= nums[l]){
                if(nums[l] <= target && nums[m] > target){
                    r = m-1;
                }
                else{
                    l = m+1;
                }
            }
            else{
                if(nums[m] < target && nums[r] >= target){
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            }
        }
        if(nums[l]==target)return l;

        return -1;
    }
}
