class Solution {
    static int [] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int [n];
        Arrays.fill(dp, -1);

        return solve(nums,0,n);
    }

    public static int solve(int [] arr, int i, int n){
        if(i >= n)return 0; 

        if(dp[i] != -1)return dp[i];

        int skip = solve(arr, i+1, n);
        int take = arr[i] + solve(arr, i+2, n);

        return dp[i] =  Math.max(skip, take);
    }
}