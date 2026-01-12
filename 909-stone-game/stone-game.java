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

        int [] dp = new int [n];

        for(int i = 1;i<n;i++){
            dp[i] = arr[i]; // Base Case
            for(int j = i - 1;j>=0;j--){
                //quick tip while filling the 1D just focus on j because 
                //Here is no role of i inside j loop and also we can see
                //from max function we only need j+1 and j so we can optimize 
                // it using 1D dp
                dp[j] = Math.max(
                    (arr[j] - dp[j+1]),
                    (arr[i] - dp[j])
                );
            }
        }

        return dp[0];
    }
}