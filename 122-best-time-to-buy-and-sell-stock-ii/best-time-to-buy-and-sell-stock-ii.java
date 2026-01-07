class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
       // int [][] dp = new int [n+1][2];
        //for(int [] arr:dp)Arrays.fill(arr,-1);
        //return solve(prices,0,n, true);
        //return solveMemo(prices,0,n,1,dp);
        return solveTab(prices);
    }

    //recursive solution
    public static int solve(int [] prices,int i,int n,boolean flag){
        if(i >= n)return 0;

        if(flag){
            return Math.max(-prices[i]+solve(prices,i+1,n,false),solve(prices,i+1,n,true));
        }
        else return Math.max(prices[i]+solve(prices,i+1,n,true),solve(prices,i+1,n,false));
    }

    //Memoized solution
    public static int solveMemo(int [] prices,int i,int n,int flag,int [][] dp ){
          if(i >= n )return 0;

          if(dp[i][flag] != -1)return dp[i][flag];

            if(flag == 1){
            return dp[i][flag] = Math.max(-prices[i]+solveMemo(prices,i+1,n,0,dp), solveMemo(prices,i+1,n,1,dp));
        }
        else return dp[i][flag] = Math.max(prices[i]+solveMemo(prices,i+1,n,1,dp),solveMemo(prices,i+1,n,0,dp));
    }

    public static int solveTab(int [] prices){
        int n = prices.length;

        int [][] dp = new int [n+1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int i = n-1;i>=0;i--){
            int profit  = 0;
            for(int j = 0;j<= 1;j++){
               if(j == 1){
                profit = Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
               }
               else{
                profit = Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
               }

               dp[i][j] = profit;
            }
        }

        return dp[0][1];
    }
}