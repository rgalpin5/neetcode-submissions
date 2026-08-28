class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1) return (nums[0] == target)? 0 : -1;
        if(nums.length == 2){
            if(nums[0] == target) return 0;
            if(nums[1] == target) return 1;
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = right / 2;

        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(mid - 1 >= 0 && nums[mid-1] == target) return mid-1;
            if(mid + 1 < nums.length && nums[mid+1] == target) return mid+1;
            if(nums[left] == target) return left;
            if(nums[right] == target) return right;

            if(nums[mid] > target) {
                if(nums[left] < target){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }

            }
            //nums=[L5,1,M2,3,R4] target=1
            else if(nums[mid] < target){
                if(nums[right] > target) {
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }

        }
        if(left < nums.length && nums[left] == target)return left;
        else if(right >= 0 && nums[right] == target) return right;
        return -1;

    }
}
