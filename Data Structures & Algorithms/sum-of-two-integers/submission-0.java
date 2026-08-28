class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int res = 0;
        int bitA = 0;
        int bitB = 0;
        for(int i = 0; i < 32; i++) {
            bitA = ((a >> i) & 1);
            bitB = ((b >> i) & 1);
            if(bitA == bitB){
                if(carry == 1){
                    res |= (1 << i) ;
                }
                else{
                    res |= (0 << i);
                }
                carry = bitA & bitB;
                
            }
            else{
                if(carry == 1){
                    res |= (0 << i);
                }
                else{
                    res |= (1 << i);
                }

                carry = (bitA | bitB) & carry;
            }
            
        }
        return res;
    }
}
