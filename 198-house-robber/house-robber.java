class Solution {
    static int [][] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i:nums)sum += i;

        dp = new int [n+1][sum+1];

        for(int [] arr:dp)Arrays.fill(arr,-1);

        return solveRec(nums,0,0,n);
    }

    public static int solveRec(int [] h, int i,int s,int n){
        if(i >= n)return s;

       // if(i == n-2 || i == n-1)return s;
       if(dp[i][s] != -1)return dp[i][s];

        int take = solveRec(h,i+2,s + h[i],n);
        int notTake = solveRec(h,i+1,s,n);

        return dp[i][s] = Math.max(take,notTake);
    }
}