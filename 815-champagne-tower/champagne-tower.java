class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double [][] dp = new double[query_row+2][query_row+2];

        dp[0][0] = poured;

        for(int i = 0;i<query_row;i++){
            for(int j = 0;j<=i;j++){
                if(dp[i][j] > 1){
                    double extra = (dp[i][j] - 1)/2.0;

                    dp[i+1][j] += extra;
                    dp[i+1][j+1] += extra;
                }
            }
        }

        return Math.min(1.0,dp[query_row][query_glass]);
    }
}