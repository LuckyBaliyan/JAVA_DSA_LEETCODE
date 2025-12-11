class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int [][] dp = new int [r][c];

        for(int [] arr:dp)Arrays.fill(arr,-1);
        return solve(grid,r-1,c-1,dp);
    }

    public static int solve(int [][] grid,int r,int c,int [][] dp){
        if(r < 0 || c < 0)return Integer.MAX_VALUE;
        if(r == 0 && c == 0)return grid[0][0];

        if(dp[r][c] != -1)return dp[r][c];

        int first = solve(grid,r-1,c,dp);
        int second = solve(grid,r,c-1,dp);

        return dp[r][c] =  Math.min(first,second)+grid[r][c];
    }
}