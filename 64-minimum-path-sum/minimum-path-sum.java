class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int [][] dp = new int [r][c];

        for(int [] arr:dp)Arrays.fill(arr,-1);
        return solve(grid,r,c,dp);
    }

    // Memoization Approach --->
    /*
    public static int solve(int [][] grid,int r,int c,int [][] dp){
        if(r < 0 || c < 0)return Integer.MAX_VALUE;
        if(r == 0 && c == 0)return grid[0][0];

        if(dp[r][c] != -1)return dp[r][c];

        int first = solve(grid,r-1,c,dp);
        int second = solve(grid,r,c-1,dp);

        return dp[r][c] =  Math.min(first,second)+grid[r][c];
    }
    */

    //Tabulation -->
    public static int solve(int [][] grid,int r,int c,int [][] dp){
        dp[0][0] = grid[0][0];
        //if(dp[r][c] != -1)return dp[r][c];

        for(int i = 1;i<r;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int j = 1;j<c;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i = 1;i<r;i++){
            for(int j = 1;j<c;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[r-1][c-1];
    }
}