class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int kLower = 1;
        int kUpper = piles[0];
        for(int p : piles){
            kUpper = Math.max(kUpper, p);
        }
        if(h == piles.length) return kUpper;

        int kMid = kLower + (kUpper - kLower) / 2;
        int time = 0;
        while(kLower < kUpper){
            kMid = kLower + (kUpper - kLower) / 2;
            time = 0;
            for(int p : piles){

                time += Math.ceil((double) p / kMid);
                
            }
            if(time <= h){
                kUpper = kMid;
            }
            else{
                kLower = kMid+1;
            }


        }
        return kLower;






    }
}
