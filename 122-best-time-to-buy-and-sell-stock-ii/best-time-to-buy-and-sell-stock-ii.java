class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int [n+1][2];
        for(int [] arr:dp)Arrays.fill(arr,-1);
        //return solve(prices,0,n, true);
        return solveMemo(prices,0,n,1,dp);
    }

    //recursive solution
    public static int solve(int [] prices,int i,int n,boolean flag){
        if(i >= n)return 0;

        if(flag){
            return Math.max(-prices[i]+solve(prices,i+1,n,false),solve(prices,i+1,n,true));
        }
        else return Math.max(prices[i]+solve(prices,i+1,n,true),solve(prices,i+1,n,false));
    }

    public static int solveMemo(int [] prices,int i,int n,int flag,int [][] dp ){
          if(i >= n )return 0;

          if(dp[i][flag] != -1)return dp[i][flag];

            if(flag == 1){
            return dp[i][flag] = Math.max(-prices[i]+solveMemo(prices,i+1,n,0,dp), solveMemo(prices,i+1,n,1,dp));
        }
        else return dp[i][flag] = Math.max(prices[i]+solveMemo(prices,i+1,n,1,dp),solveMemo(prices,i+1,n,0,dp));
    }
}