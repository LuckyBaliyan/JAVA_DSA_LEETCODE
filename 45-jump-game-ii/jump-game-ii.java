class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        return solve(nums,0,n,dp);
    }

    public static int solve(int [] arr,int i,int n,int [] dp){
        if(i == n-1)return 0;
        if(i >= n)return 0;

        if(dp[i] != -1)return dp[i];

        int ans = Integer.MAX_VALUE;
        for(int j = 1;j<=arr[i];j++){
            int ways = solve(arr,i+j,n,dp);
            if(ways != Integer.MAX_VALUE)
            ans = Math.min(1+ways,ans);
        }

        return dp[i] =  ans;
    }
}