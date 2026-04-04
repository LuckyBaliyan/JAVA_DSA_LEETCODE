class Solution {
    static int [][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int [n][m];
        
        /*for(int [] arr:memo)Arrays.fill(arr,-1);
        return solveRec(n - 1,m - 1);*/

        return solveTab(n,m);
    }

    public static int solveTab(int n, int m){
        /*int [][] dp = new int [n][m];

        //base case:- 
        dp[0][0] = 1;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
               if(i == 0 && j == 0)continue;
               int up = 0;
               int down = 0;
               if(i > 0)up = dp[i-1][j];
               if(j > 0)down = dp[i][j-1];

               dp[i][j] = up + down;
            }
        }
        return dp[n-1][m-1];
        */

        int [] dp = new int [m];

        //fill each column with 1 for row(0)
        for(int i = 0;i<m;i++)dp[i] = 1;

        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                dp[j] = dp[j] + dp[j-1];
            }
        }

        return dp[m-1];
    }

    public static int solveRec(int n, int m){
        if(n < 0 || m < 0)return 0;
        if(n == 0 && m == 0)return 1;

        if(memo[n][m] != -1)return memo[n][m];

        return memo[n][m] = solveRec(n-1,m) + solveRec(n,m-1);
    }
}