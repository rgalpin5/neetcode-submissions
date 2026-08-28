class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] dpPrev = new int[nums.length];
        int[] dpAft = new int[nums.length];
        Arrays.fill(dpPrev, 1);
        Arrays.fill(dpAft, 1);
        int n = nums.length;
        int end = n-1;

        for(int i = 1; i < n-1; i++) {
            dpPrev[i] = dpPrev[i-1] * nums[i-1];
            dpAft[end-i] = dpAft[end - i + 1] * nums[end - i + 1];
        }

       
        int[] ans = new int[end + 1];
        for(int i = 0; i < n - 1; i++){
            ans[i] = dpPrev[i] * dpAft[i];
        }
        ans[n-1] = dpPrev[n-2] * nums[n-2];
        ans[0] = dpAft[1] * nums[1];
        return ans;
    }
}  
