class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while(left < right) {
            mid = left + (right - left) / 2;
            if(nums[right] < nums[mid]) left = mid + 1;
            else right = mid;
        }
        
        int midPoint = left;
        if(nums[nums.length - 1] < target) {
            right = midPoint;
            left = 0;
        }
        else {
            right = nums.length - 1;
        }
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                right = mid - 1;
            }
            else left = mid + 1;
        }
        
        return -1;
    }
}
