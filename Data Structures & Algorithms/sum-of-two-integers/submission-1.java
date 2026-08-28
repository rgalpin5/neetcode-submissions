class Solution {
    public int getSum(int a, int b) {
        int ans = 0;
        int carry = 0;
        for(int i = 0; i < 32; i++) {
            System.out.println("Test");
            int aBit = (a >> i) & 1;
            int bBit = (b >> i) & 1;
            /*
            a = 0100
            b = 0111
            a ^ b = 1
            ans = 110
            */
            int curBit = aBit ^ bBit ^ carry;
            carry= (aBit + bBit + carry) >= 2 ? 1 : 0;
            if(curBit != 0) {
                ans |= (1 << i);
            }

            
        }
        if (ans > 0x7FFFFFFF) {
                ans = ~(ans ^ 0xFFFFFFFF);
        }

        return ans;
    }
}
