class Solution {
    public int tribonacci(int n) {
        //return (int) tribonacciRec((long) n);

        long [] dp = new long [n+1];
        //return (int) tribonacciMemo(n,dp);

        return (int) tribonacciTab(n,dp);
    }

   /* By Plain Recursion
    public static long tribonacciRec(long n){
        if(n <= 0)return 0;
        if(n == 1 || n == 2)return 1;

        return tribonacciRec(n-1)+tribonacciRec(n-2)+tribonacciRec(n-3);
    }
    */

    /*public static long tribonacciMemo(int n,long [] dp){
        if(n<=0)return 0;
        if(n<=2)return 1;

        //check if we have the solution for the called subtree then return it 
        // int O(1)

        if(dp[n] != 0)return dp[n];

        dp[n]  = tribonacciMemo(n-1,dp)+tribonacciMemo(n-2,dp)+
        tribonacciMemo(n-3,dp);
        return dp[n];
    }
    */

    public long tribonacciTab(int n,long [] dp){
        if(n <= 0)return 0;
        if(n<=2)return 1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[n];
    }
}