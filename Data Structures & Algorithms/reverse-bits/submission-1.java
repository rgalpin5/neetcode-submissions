class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 1; i <= 32; i++) {
            ans |= (n & 1) << 32 - i;
            n = n >> 1;
        }
        return ans;
    }
}
