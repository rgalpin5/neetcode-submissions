class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        if(amount == 0) return 0;
        boolean[] dp = new boolean[amount];
        dp[0] = true;
        
        return helper(amount, coins, dp, 1);
    }

    private int helper(int amount, int[] coins, boolean[] dp, int index) {
        boolean valChanged = false;
        boolean[] newDP = Arrays.copyOf(dp, dp.length);
        for(int coin : coins){
            for(int i = 0; i < dp.length; i++){
                if(dp[i]){
                    if(i + coin < amount && dp[i+coin] == false) {
                        valChanged = true;
                        newDP[i + coin] = true;
                    }
                    else if(i + coin == amount) return index;
                }
            }
        }
        dp = newDP;
        if(valChanged) return helper(amount, coins, dp, index+1);
        return -1;
    }
}
