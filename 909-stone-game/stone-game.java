class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
       // int [][] dp = new int [n][n];
        // for(int [] a:dp)Arrays.fill(a,-1);

        int diff =  solveTab(piles);
        return diff > 0;
    }

    public static int solve(int [] arr,int l,int r,int [][] dp){
        int n = arr.length;

        if(l==r)return arr[l];
        if(dp[l][r] != -1)return dp[l][r];

        return dp[l][r] = Math.max(
                          arr[l] - solve(arr,l+1,r,dp),
                          arr[r] - solve(arr,l,r-1,dp)
                        );
    } 

    public static int solveTab(int [] arr){
        int n = arr.length;

        int [][] dp = new int [n][n];

        for(int i = 1;i<n;i++){
            for(int j = i - 1;j>=0;j--){
                dp[j][i] = Math.max(
                    (arr[j] - dp[j+1][i]),
                    (arr[i] - dp[j][i-1])
                );
            }
        }

        return dp[0][n-1];
    }
}