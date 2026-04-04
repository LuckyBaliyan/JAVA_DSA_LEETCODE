class Solution {
    static int [][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        /*memo = new int [n][m];

        for(int [] arr:memo)Arrays.fill(arr,-1);*/

        ///return solveRec(obstacleGrid,n-1,m-1);

        return solveTab(obstacleGrid,n,m);
    }

    public static int solveTab(int [][] arr, int n,int m){
        int [] dp = new int [m];

        if(arr[0][0] == 1)return 0;
        if(arr[n-1][m-1] == 1)return 0;

        dp[0] = 1;
        for(int j = 1; j < m; j++){
            if(arr[0][j] == 1) dp[j] = 0;
            else dp[j] = dp[j-1];
        }

        for(int i = 1;i<n;i++){
            if(arr[i][0] == 1) dp[0] = 0;
            for(int j = 1;j<m;j++){
                if(arr[i][j] == 1)dp[j] = 0;
                else dp[j] = dp[j] + dp[j-1];
            }
        }

        return dp[m-1];
    }

    public static int solveRec(int [][] arr,int n, int m){
        if(n < 0 || m < 0)return 0;

        //if obstacle we can't take that path
        if(arr[n][m] == 1)return 0;

        if(n == 0 && m == 0)return 1;

        if(memo[n][m] != -1)return memo[n][m];

        return memo[n][m] = solveRec(arr,n-1,m) + solveRec(arr,n,m-1);
    }
}