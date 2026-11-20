class Solution {
    public int[] countBits(int n) {
        if(n == 0) return new int[]{0};
        int offset = 1;
        int[] output = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if(i == offset * 2) {
                offset = offset * 2;
            }
            output[i] = output[i - offset] + 1;
            
        }

        return output;
    }
}
