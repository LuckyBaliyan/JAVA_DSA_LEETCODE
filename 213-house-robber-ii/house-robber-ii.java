class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)return nums[0];

        int [] dp1 = new int [n];
        Arrays.fill(dp1,-1);

        int [] dp2 = new int [n];
        Arrays.fill(dp2,-1);

        //int case1 = solve(nums,0,n-2,dp1);
        //int case2 = solve(nums,1,n-1,dp2);

        //return Math.max(case1,case2);

        int c1 = solve(nums,n-2,0);
        int c2 = solve(nums,n-1,1);

        return Math.max(c1,c2);
    }
    /*
    public static int solve(int [] arr,int i,int end,int [] dp){
        if(i > end)return 0;

        if(dp[i] != -1)return dp[i];

        return dp[i] =  Math.max(arr[i]+solve(arr,i+2,end,dp),solve(arr,i+1,end,dp));
    }
    */

    public static int solve(int [] arr,int end,int start){
       int n = arr.length;
       int [] dp = new int [n+2];

       for(int i = end;i>=start;i--){
        dp[i] = Math.max(dp[i+1],arr[i]+dp[i+2]);
       }

       return dp[start];
    }
}