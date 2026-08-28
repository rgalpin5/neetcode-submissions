class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int m = r/2;

        while(l<r){

            m = l +(r-l)/2;

            if(nums[m] > nums[r]){
                l = m+1;
            }
            else{
                r=m;
            }

            
        }
        return nums[l];
    }
}
