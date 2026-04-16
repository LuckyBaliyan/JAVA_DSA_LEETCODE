class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int [coins.length][amount+1];
        int n = coins.length;

        for(int i = 0;i<n; i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j< amount + 1; j++){
            if(j % coins[0] == 0)dp[0][j] = j / coins[0];
            else dp[0][j] = Integer.MAX_VALUE;
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j < amount + 1; j++){
               int skip = dp[i-1][j];
               int take = Integer.MAX_VALUE;

               if(j>= coins[i] && 
               dp[i][j - coins[i]] != Integer.MAX_VALUE)
               {
                take = dp[i][j - coins[i]] + 1;
               }

               dp[i][j] = Math.min(skip, take);
            }
        }

        return dp[n-1][amount] == Integer.MAX_VALUE ? -1: dp[n-1][amount];
    }
}