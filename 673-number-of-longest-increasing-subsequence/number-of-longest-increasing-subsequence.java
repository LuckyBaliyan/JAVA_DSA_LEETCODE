class Solution {
    public int findNumberOfLIS(int[] nums) {
        return solveTab(nums);
    }

    public static int solveTab(int [] arr){
        int n = arr.length;

        int [][] dp = new int [n+1][n+1];
        int [][] dpCnt = new int [n+1][n+1];

        for(int j = 0;j<=n;j++)dpCnt[n][j] = 1;

        for(int i = n-1;i>=0;i--){
            for(int j = -1;j<=i-1;j++){
                int take = 0,takeCnt = 0;
                if(j == -1 || arr[i] > arr[j]){
                    take = 1 + dp[i+1][i+1];
                    takeCnt = dpCnt[i+1][i+1];
                }

                int notTake = dp[i+1][j+1];
                int notTakeCnt = dpCnt[i+1][j+1];

                dp[i][j+1] = Math.max(take, notTake);

                if(take > notTake){
                    dpCnt[i][j+1] = takeCnt;
                }
                else if(take < notTake){
                    dpCnt[i][j+1] = notTakeCnt;
                }
                else dpCnt[i][j+1] = takeCnt + notTakeCnt;
            }
        }

        return dpCnt[0][0];
    }
}