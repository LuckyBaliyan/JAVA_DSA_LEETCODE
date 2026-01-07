class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][][] dp = new int [n+1][2][3];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<2;j++){
                for(int k = 0;k<3;k++) dp[i][j][k] = -1;
            }
        }

        //return solve(prices,0,n,true,2);

        return solveMemo(prices,0,n,1,2,dp);
        
    }
    //recursive
    public static int solve(int [] prices,int i,int n,boolean flag,int limit){
        if(i >= n)return 0;
        if(limit <= 0)return 0;

        if(flag){
            return Math.max(-prices[i]+solve(prices,i+1,n,false,limit),solve(prices,i+1,n,true,limit));
        }
        else return Math.max(prices[i]+solve(prices,i+1,n,true,limit-1),solve(prices,i+1,n,false,limit));
    }

      //Memoized solution
    public static int solveMemo(int [] prices,int i,int n,int flag,int limit,int [][][] dp ){
          if(i >= n )return 0;
          if(limit == 0)return 0;

          if(dp[i][flag][limit] != -1)return dp[i][flag][limit];

            if(flag == 1){
            return dp[i][flag][limit] = Math.max(-prices[i]+solveMemo(prices,i+1,n,0,limit,dp), solveMemo(prices,i+1,n,1,limit,dp));
        }
        else return dp[i][flag][limit] = Math.max(prices[i]+solveMemo(prices,i+1,n,1,limit-1,dp),solveMemo(prices,i+1,n,0,limit,dp));
    }

}