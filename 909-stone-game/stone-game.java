class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int [][] dp = new int [n][n];
        for(int [] a:dp)Arrays.fill(a,-1);

        int diff =  solve(piles,0,n-1,dp);
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
}