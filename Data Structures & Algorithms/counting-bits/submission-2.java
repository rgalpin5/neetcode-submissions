class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        ans[0] = 0;
        if(n == 0) return ans;
        ans[1] = 1;
        if(n == 1) return ans;
        ans[2] = 1;
        if(n == 2) return ans;
        int currLargest = 4;
        for(int i = 3; i <= n; i++) {
            if(i / currLargest == 1) {
                currLargest *= 2;
                ans[i] = 1;
            }
            int spotsBehind = currLargest / 2;
            ans[i] = ans[i - spotsBehind] + 1;
            if(i / currLargest == 1) currLargest *= 2;
        }
        return ans;
    }
    //[0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1]
}
