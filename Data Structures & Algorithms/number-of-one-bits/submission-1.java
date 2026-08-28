class Solution {
    public int hammingWeight(int n) {
        int oneBits = 0;
        while(n > 0) {
            int currBit = n & 1;
            if(currBit == 1) oneBits++;
            n = n >> 1;
        }

        return oneBits;
    }
}
