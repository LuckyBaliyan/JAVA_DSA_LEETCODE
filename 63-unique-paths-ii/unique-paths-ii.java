class Solution {
    int [][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // return solveRec(obstacleGrid,0,0); --> O(2^(m+n)), O(m+n)
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(obstacleGrid[m-1][n-1] == 1)return 0;
        
        dp = new int [m][n];
        return solveMemo(obstacleGrid,0,0,dp);
    }

    public int solveMemo(int [][] grid,int i,int j,int [][] dp){
        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j >= n)return 0;

        if(grid[i][j] == 1)return 0;
        if(i == m-1 && j == n-1)return 1;

        if(dp[i][j] != 0)return dp[i][j];

        return dp[i][j] = solveMemo(grid,i+1,j,dp) + 
        solveMemo(grid,i,j+1,dp);
    }

    public int solveRec(int [][] grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j >= n)return 0;

        // Keeping it here because we have to check bounds first 
        // then what if the last tile also have the obsticle  
        if(grid[i][j] == 1)return 0;
        if(i == m - 1 && j == n-1)return 1;

        return solveRec(grid,i+1,j) + solveRec(grid,i,j+1);
    };
}