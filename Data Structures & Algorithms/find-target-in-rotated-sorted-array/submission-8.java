class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int m;
        while(l<=r){
            m = l+(r-l)/2;
            if (nums[m] == target) {
                return m;
            }
            // nums=[3,4,5,l6,m1,r2] target 1:
            if(nums[l] <= nums[m]){
                //left half sorted
                if(target>=nums[l]&&target<nums[m]){
                    r=m-1;
                }
                else{
                    l=m+1;
                }
            }
            else{
                //right half sorted
                if(target>nums[m] && target<=nums[r]){
                    l=m+1;
                }
                else{
                    r = m-1;
                }
            }
            
        }
        
        return -1;
    }
}
