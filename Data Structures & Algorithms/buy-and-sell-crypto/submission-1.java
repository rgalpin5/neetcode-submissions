class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int profit = 0;
        int r = 1;
        int l = 0;
        while(r < prices.length) {
            if(prices[r] < prices[l]) {
                l = r;
            }
            profit = Math.max(profit, prices[r] - prices[l]);
            r++;
        }
        return profit;
    }
}
