class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        return solve(nums,0,n,dp);
    }

    public static int solve(int [] nums,int indx,int n,int [] dp){

        if(indx >= n)return 0;

        if(dp[indx] != -1) return dp[indx];

        int first = nums[indx] + solve(nums,indx + 2,n,dp);
        int second = solve(nums,indx +  1,n,dp);

        dp[indx] = Math.max(first,second); 
        return dp[indx];
    }
}