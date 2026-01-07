class Solution {
    public int lengthOfLIS(int[] nums) {
        int n  = nums.length;
        int [][] dp = new int [n+1][n+1];

        for(int [] arr:dp)Arrays.fill(arr,-1);

        return solveMemo(nums,0,-1,n,dp);
    }

    public static int solveMemo(int [] nums,int i,int prev,int n,int [][] dp){
        if(i>=n)return 0;

        if(dp[i][prev+1]!= -1)return dp[i][prev+1];

        int skip = solveMemo(nums,i+1,prev,n,dp);
        int take = 0;

        if(prev == -1 || nums[i] > nums[prev]){
            take = 1 + solveMemo(nums,i+1,i,n,dp);
        }

        return dp[i][prev+1] =  Math.max(take,skip);
    }
}