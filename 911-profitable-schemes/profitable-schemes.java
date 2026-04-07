class Solution {
    static int minP;
    static int MOD = (int) 1e9 + 7;
    static int [][][] dp;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        minP = minProfit;

        dp  = new int [n+1][101][101];
        for(int i = 0;i < n+1; i++){
            for(int j = 0; j< 101 ; j++){
                for(int k = 0; k < 101; k++)dp[i][j][k] = -1;
            }
        }

        return solve(n, m, minP, 0, 0, group, profit); 
    }

    public static int solve(int n, int m, int minP, int i, int p, int [] group, int [] profit){
        if(n < 0)return 0;
       
        //we got a problem in dp size when our p >>>> minP but we are only counting
        // on the basis of minP <= p so why not to keep p=minP when it get's bigger
        if(p > minP) p = minP;

        if(i >= m){
            if(n >= 0 && p >= minP){
                return 1;
            }
            else return 0;
        }

        if(dp[n][i][p] != - 1)return dp[n][i][p];

        int take = solve(n - group[i], m, minP, i+1, p + profit[i], group, profit);
        int skip = solve(n, m, minP, i+1, p, group, profit);

        return dp[n][i][p] =  (take + skip) % MOD;
    }
}