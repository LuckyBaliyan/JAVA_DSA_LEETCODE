class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        return solveTab(nums,n);
        //return solveMemo(nums,0,n,dp);
    }

/*
    public static int solveMemo(int [] nums,int indx,int n,int [] dp){

        if(indx >= n)return 0;

        if(dp[indx] != -1) return dp[indx];

        int first = nums[indx] + solveMemo(nums,indx + 2,n,dp);
        int second = solveMemo(nums,indx +  1,n,dp);

        dp[indx] = Math.max(first,second); 
        return dp[indx];
    }
*/
    public static int solveTab(int [] nums,int n){
        int [] dp = new int [n+1];

        //Base Case
        dp[n] = 0;
        dp[n-1] = nums[n-1];

        for(int i = n-2;i>=0;i--){
            dp[i] = Math.max(dp[i+1],nums[i]+dp[i+2]);
        }

        return dp[0];
    }
}