class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        //int [][] dp  = new int [n+1][2];
        //for(int [] arr:dp)Arrays.fill(arr,-1);
        //return solve(prices,0,n,1);

        //return solveMemo(prices,0,n,1,dp);

        return solveTab(prices);
    }

    public static int solve(int [] prices,int i,int n,int flag){
        if(i >= n)return 0;

        if(flag == 1){
            int buy =  solve(prices,i+1,n,0) - prices[i];
            int skip = solve(prices,i+1,n,1);

            return Math.max(buy,skip);
        }
        else{
            //because we are only intended to skip one stock when we complete a transaction
            //i.e buy and then sell
            int sell = solve(prices,i+2,n,1) + prices[i];
            int skip = solve(prices,i+1,n,0);
            return Math.max(sell,skip);
        }
    }

    public static int solveMemo(int [] prices,int i,int n,int flag,int [][] dp){
        if( i >= n)return 0;
        
        if(dp[i][flag] != -1)return dp[i][flag];

        if(flag == 1){
            int buy =  solveMemo(prices,i+1,n,0,dp) - prices[i];
            int skip = solveMemo(prices,i+1,n,1,dp);

            return dp[i][flag] = Math.max(buy,skip);
        }
        else{
            //because we are only intended to skip one stock when we complete a transaction
            //i.e buy and then sell
            int sell = solveMemo(prices,i+2,n,1,dp) + prices[i];
            int skip = solveMemo(prices,i+1,n,0,dp);
            return dp[i][flag] = Math.max(sell,skip);
        }
    }

    public static int solveTab(int [] prices){
        int n = prices.length;

        int [][] dp = new int [n+2][2];

        for(int i = n-1; i>=0; i--){
            int maxProfit = 0;
            for(int j = 0;j<2;j++){
               if(j == 1){
                maxProfit = Math.max(dp[i+1][0]-prices[i],dp[i+1][1]);
               }
               else maxProfit = Math.max(dp[i+2][1]+prices[i],dp[i+1][0]);

                dp[i][j] = maxProfit;
            }
        }

        return dp[0][1];
    }
}