class Solution {
    public int maxProfit(int[] prices) {
        int maxProf = 0;
        int tempProf = 0;
        int minPrice = prices[0];
        int maxPrice = 0;

        for(int i = 0;i<prices.length;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
                maxPrice = 0;
            }
            if(prices[i] > maxPrice){
                maxPrice = prices[i];
            }
            tempProf = maxPrice - minPrice;
            maxProf = Math.max(tempProf, maxProf);

            
        }
        return maxProf;

    }
}
