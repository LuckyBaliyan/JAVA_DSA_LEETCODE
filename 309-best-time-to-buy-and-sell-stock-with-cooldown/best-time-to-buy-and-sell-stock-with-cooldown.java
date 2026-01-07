class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int [][] dp  = new int [n+1][2];
        for(int [] arr:dp)Arrays.fill(arr,-1);
        //return solve(prices,0,n,1);

        return solveMemo(prices,0,n,1,dp);
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
}