class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;

        int [][] dp = new int [n][n];

        for(int [] arr:dp)Arrays.fill(arr,Integer.MAX_VALUE);

        for(int c = 0;c<n;c++){
            ans = Math.min(ans,solve(0,c,matrix,n,dp));
        }

        return ans;
    }

    public static int solve(int r,int c,int [][] matrix,int n,int [][] dp){
        if(c < 0 || c >=n)return Integer.MAX_VALUE;
        if(r == n-1)return matrix[r][c];

        if(dp[r][c] != Integer.MAX_VALUE)return dp[r][c];

        int first = solve(r+1,c,matrix,n,dp);
        int second = solve(r+1,c+1,matrix,n,dp);
        int third = solve(r+1,c-1,matrix,n,dp);

        return dp[r][c] = matrix[r][c]+Math.min(Math.min(first,second),third);
    }
}