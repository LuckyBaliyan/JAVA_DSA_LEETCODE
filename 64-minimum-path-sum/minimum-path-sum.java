class Solution {
    //static int [][] dp;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        /*dp  = new int [n][m];

        for(int [] arr: dp)Arrays.fill(arr,-1);*/

        //return solve(grid,n-1,m-1);

        return solveTab(grid);
    }

    public int solveTab(int [][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int [][] dp = new int [n][m];

        //base case
        dp[0][0] = arr[0][0];
        
        //handle the sum of up, left boundaries
        for(int i = 1;i<n;i++)dp[i][0] = arr[i][0] + dp[i-1][0];
        for(int j = 1;j<m;j++)dp[0][j] = arr[0][j] + dp[0][j-1];

        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                int minCell = Math.min(dp[i-1][j] , dp[i][j-1]);
                dp[i][j] = arr[i][j] + minCell;
            }
        }

        return dp[n-1][m-1];
    }

    /*public int solve(int [][] arr, int i, int j){
        if(i < 0 || j < 0)return Integer.MAX_VALUE;
        if(i == 0 && j == 0)return arr[i][j];

        if(dp[i][j] != -1)return dp[i][j];

        int up = solve(arr, i-1, j);
        int left = solve(arr, i, j-1);

        return dp[i][j] =  arr[i][j] + Math.min(up, left);
    }*/
}