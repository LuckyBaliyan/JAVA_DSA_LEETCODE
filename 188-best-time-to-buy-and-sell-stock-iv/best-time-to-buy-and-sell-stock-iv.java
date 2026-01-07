class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int [][][] dp = new int [n+1][k+1][2];

        for(int [][] arr : dp){
            for(int [] arr1: arr)Arrays.fill(arr1,-1);
        }

        //return solve(prices,0,n,k,1);
        return solveMemo(prices,0,n,k,1,dp);
    }

    //recursion
    public static int solve(int [] prices,int i,int n,int k,int flag){
        if(i>=n)return 0;

        if(k == 0)return 0;

        if(flag == 1){
            int buy =  solve(prices,i+1,n,k,0) - prices[i];
            int skip = solve(prices,i+1,n,k,1);

            return Math.max(buy,skip);
        }
        else {
            int sell = solve(prices,i+1,n,k-1,1) + prices[i];
            int skip = solve(prices,i+1,n,k,0);

            return Math.max(sell,skip);
        }
    }

    public static int solveMemo(int [] prices,int i,int n,int k,int flag,int [][][] dp){
        if(i>=n)return 0;
        if(k<=0)return 0;
       
        if(dp[i][k][flag] != -1)return dp[i][k][flag];

        if(flag == 1){
            int buy = solveMemo(prices,i+1,n,k,0,dp) - prices[i];
            int skip = solveMemo(prices,i+1,n,k,1,dp);

            return dp[i][k][flag] = Math.max(buy,skip);
        }
        else{
            int sell = solveMemo(prices,i+1,n,k-1,1,dp) + prices[i]; // tarnsaction done!
            int skip = solveMemo(prices,i+1,n,k,0,dp);

            return dp[i][k][flag] = Math.max(sell,skip);
        }

    }
}