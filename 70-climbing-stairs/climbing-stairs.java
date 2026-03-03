class Solution {
    static int [] dp;
    public int climbStairs(int n) {
        dp = new int [n+1];
        Arrays.fill(dp,-1);

        return solveRec(n);
    }

    public static int solveRec(int n){
        if(n < 0)return 0;
        if(n == 0)return 1;

        if(dp[n] != -1)return dp[n];

        return dp[n] = solveRec(n-1) + solveRec(n-2);
    }
}