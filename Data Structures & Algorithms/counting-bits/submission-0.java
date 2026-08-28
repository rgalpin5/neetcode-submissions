class Solution {
    public int[] countBits(int n) {
        int[] onesInNum = new int[n+1];
        if(n == 0) return new int[]{0};

        onesInNum[0] = 0;
        onesInNum[1] = 1;
        int spacesBefore = 2;
        for(int i = 2; i < onesInNum.length; i++) {
            if(spacesBefore*2 == i){
                spacesBefore *= 2;
                onesInNum[i] = 1;
                continue;
            }
            //[0,1,0,0,0]
            //i = 2
            //spacesbefore = 2
            onesInNum[i] = onesInNum[i-spacesBefore]+1;

        }

        return onesInNum;
        /*
        0000 0 0
        0001 1 1
        0010 2 1
        0011 3 2
        0100 4 1
        0101 5 2
        0110 6 2
        0111 7 3
        1000 8 1 
        1001 9 2
        1010 10 2
        1011 11 3
        1100 12 2
        1101 13 3
        1110 14 3
        1111 15 4
        */
    }
}
