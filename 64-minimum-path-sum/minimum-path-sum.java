class Solution {
    static int [][] dp;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp  = new int [n][m];

        for(int [] arr: dp)Arrays.fill(arr,-1);

        return solve(grid,n-1,m-1);
    }

    public int solve(int [][] arr, int i, int j){
        if(i < 0 || j < 0)return Integer.MAX_VALUE;
        if(i == 0 && j == 0)return arr[i][j];

        if(dp[i][j] != -1)return dp[i][j];

        int up = solve(arr, i-1, j);
        int left = solve(arr, i, j-1);

        return dp[i][j] =  arr[i][j] + Math.min(up, left);
    }
}