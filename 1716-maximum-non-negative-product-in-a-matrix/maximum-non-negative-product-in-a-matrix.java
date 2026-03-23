class Solution {
    static int MOD = 1000000007;
    static long [][][] dp;
    public int maxProductPath(int[][] grid) {
        int n  = grid.length;
        int m = grid[0].length;

        dp = new long [n][m][2];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                dp[i][j][0]  = Long.MIN_VALUE;
                dp[i][j][1] = Long.MAX_VALUE;
            }
        }

        long [] ans = solveRec(grid,n-1,m-1);

        if(ans[0] < 0)return -1;
        return (int) (ans[0] % MOD);
    }

    public static long[] solveRec(int [][] arr,int i,int j){
        if(i == 0 && j == 0){
            return new long [] {arr[0][0], arr[0][0]};
        }

        if(dp[i][j][0] != Long.MIN_VALUE || dp[i][j][1] != Long.MAX_VALUE){
            return new long [] {dp[i][j][0], dp[i][j][1]};
        }

        //overall max and min of left and right
        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        if(i > 0){
            long [] up = solveRec(arr,i-1,j);
            long max = up[0];
            long min = up[1];

            maxVal = Math.max(maxVal,Math.max(max*arr[i][j],min*arr[i][j]));
            minVal = Math.min(minVal,Math.min(max*arr[i][j],min*arr[i][j]));
        }
        if(j > 0){
            long [] left = solveRec(arr,i,j-1);
            long max = left[0];
            long min = left[1];

            maxVal = Math.max(maxVal,Math.max(max*arr[i][j],min*arr[i][j]));
            minVal = Math.min(minVal,Math.min(max*arr[i][j],min*arr[i][j]));
        }

        //fill the dp on a deep call
        dp[i][j][0] = maxVal;
        dp[i][j][1] = minVal;

        return new long [] {maxVal,minVal};
    }
}